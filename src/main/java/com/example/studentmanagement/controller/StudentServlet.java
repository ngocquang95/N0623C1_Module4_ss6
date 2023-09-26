package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.StudentSearchDTO;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.IClazzService;
import com.example.studentmanagement.service.IStudentService;
import com.example.studentmanagement.service.impl.ClazzService;
import com.example.studentmanagement.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClazzService clazzService = new ClazzService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create": // Khi nhấn vào nút create => create.jsp
                request.setAttribute("clazzList", clazzService.findAll());
                request.getRequestDispatcher("student/create.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = studentService.findById(id);

                request.setAttribute("student", student);
                request.getRequestDispatcher("student/edit.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("clazzList", clazzService.findAll());
                // Lấy thông tin search
                StudentSearchDTO studentSearchDTO = new StudentSearchDTO();
                studentSearchDTO.setName(request.getParameter("name"));
                studentSearchDTO.setFromScore(request.getParameter("fromScore"));
                studentSearchDTO.setToScore(request.getParameter("toScore"));
                studentSearchDTO.setClazzId(request.getParameter("clazzId"));
                request.setAttribute("studentList", studentService.search(studentSearchDTO));
                request.getRequestDispatcher("student/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createStudent(request, response);
//                request.setAttribute("studentList", studentList);
//                request.getRequestDispatcher("student/list.jsp").forward(request, response);

                break;
            case "edit":
                editStudent(request, response);
//                request.setAttribute("studentList", studentList);
//                request.getRequestDispatcher("student/list.jsp").forward(request, response);
                response.sendRedirect("student?message=" + URLEncoder.encode("Chỉnh sửa thành công", "UTF-8")); // GET
                break;
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Validate dữ liệu
        Map<String, String> messageError = new HashMap<>();
        studentService.validate(request, messageError);

        if (!messageError.isEmpty()) {
            // Trường hợp bị lỗi thì gửi lại clazzList
            request.setAttribute("clazzList", clazzService.findAll());
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("score", request.getParameter("score"));
            request.setAttribute("messageError", messageError);
            request.getRequestDispatcher("student/create.jsp").forward(request, response);
            return;
        }

        Student student = new Student();
        student.setId((int) (Math.random() * 10000));
        student.setName(request.getParameter("name"));
        student.setScore(Double.parseDouble(request.getParameter("score")));
        // add thêm clazzId
        student.setClazzId(Integer.parseInt(request.getParameter("clazzId")));

        studentService.create(student);
        response.sendRedirect("student?message=" + URLEncoder.encode("Thêm mới thành công", "UTF-8")); // GET
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        student.setName(request.getParameter("name"));
        student.setScore(Double.parseDouble(request.getParameter("score")));
    }


}

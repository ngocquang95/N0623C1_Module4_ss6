package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.dto.StudentSearchDTO;
import com.example.studentmanagement.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<StudentDTO> search(StudentSearchDTO studentSearchDTO);

    Student findById(int id);

    void create(Student student);

    void validate(HttpServletRequest request, Map<String, String> messageError);
}

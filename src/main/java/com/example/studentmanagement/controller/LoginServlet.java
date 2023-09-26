package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.User;
import com.example.studentmanagement.service.IUserService;
import com.example.studentmanagement.service.impl.UserService;
import com.example.studentmanagement.util.BCryptUtil;
import com.example.studentmanagement.util.JWTUtil;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.findByUsername(username);

        if (user == null || !BCryptUtil.checkPassword(password, user.getPassword())) { // Sai username hoặc password
            response.sendRedirect("/login?message=" + URLEncoder.encode("Tài khoản hoặc mật khẩu sai", "UTF-8"));
            return;
        }

        String rememberMe = request.getParameter("remember-me");
        if("on".equals(rememberMe)) {
            String token = JWTUtil.generateTokenLogin(username);
            Cookie cookie = new Cookie("remember-me", token);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
            response.addCookie(cookie);
        }

        HttpSession session = request.getSession();
        // Lưu username vào session
        session.setAttribute("username", user.getUsername());
        response.sendRedirect("/student");
    }
}

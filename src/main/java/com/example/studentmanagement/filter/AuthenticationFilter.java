package com.example.studentmanagement.filter;

import com.example.studentmanagement.util.JWTUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@WebFilter(filterName = "AuthenticationFilter", value = "*") // * tất cả request
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();

        String servletPath = ((HttpServletRequest) request).getServletPath();
        if ("/login".equals(servletPath)) {
            chain.doFilter(request, response); // cho vào servlet
            return;
        }


        if (session.getAttribute("username") == null) {
            // Lấy cookie ở đây
            boolean isAutoLogin = false;
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    // Kiểm tra cookie có tên "remember-me"
                    if ("remember-me".equals(cookie.getName())) {
                        // Nếu tồn tại cookie "username", đánh dấu rằng người dùng đã đăng nhập
                        isAutoLogin = true;
                        String token = cookie.getValue();

                        // Lưu tên đăng nhập từ cookie vào session để duy trì trạng thái đăng nhập
                        session.setAttribute("username", JWTUtil.getUserNameFromJwtToken(token));
                    }
                }
            }

            // Nếu người dùng chưa đăng nhập (không tồn tại session và không tự động đăng nhập từ cookie)
            if (!isAutoLogin) {
                // Chuyển hướng người dùng đến trang đăng nhập và kèm theo thông báo lỗi
                httpResponse.sendRedirect("login?message=" + URLEncoder.encode("Bạn chưa đăng nhập", "UTF-8")); // GET
                return;
            }
        }

        chain.doFilter(request, response); // cho vào servlet
    }
}

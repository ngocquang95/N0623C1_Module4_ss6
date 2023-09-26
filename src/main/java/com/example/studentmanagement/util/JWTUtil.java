package com.example.studentmanagement.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {
    private static final String SECRET_KEY = "123456789"; // Khóa bí mật để ký và xác minh token
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60; // Thời gian hết hạn của token (7 ngày)

    /**
     * Tạo và trả về một JSON Web Token (JWT) cho việc đăng nhập người dùng.
     *
     * @param username Tên đăng nhập của người dùng được sử dụng trong token.
     * @return Chuỗi JWT đã được tạo.
     */
    public static String generateTokenLogin(String username) {
        return Jwts.builder()
                .setSubject(username) // Thiết lập chủ thể của token là tên đăng nhập
                .setIssuedAt(new Date()) // Thiết lập thời gian phát hành token là thời điểm hiện tại
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000)) // Thiết lập thời gian hết hạn
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Ký token bằng thuật toán HS512 và khóa bí mật
                .compact(); // Tạo token dưới dạng chuỗi
    }

    /**
     * Trích xuất tên người dùng từ JWT.
     *
     * @param token Chuỗi JWT cần được giải mã để trích xuất thông tin.
     * @return Tên đăng nhập của người dùng từ trong token.
     */
    public static String getUserNameFromJwtToken(String token) {
        // Giải mã chuỗi JWT và trích xuất thông tin
        String userName = Jwts.parser()
                .setSigningKey(SECRET_KEY) // Sử dụng khóa bí mật để xác minh tính toàn vẹn của token
                .parseClaimsJws(token) // Phân tích JWT thành Claims
                .getBody() // Truy cập phần Payload (Claims) của JWT
                .getSubject(); // Lấy tên đăng nhập từ Payload
        return userName;
    }

    public static void main(String[] args) {
        String token = generateTokenLogin("QuangNN");

        System.out.println(token);
        System.out.println(getUserNameFromJwtToken(token));
    }
}
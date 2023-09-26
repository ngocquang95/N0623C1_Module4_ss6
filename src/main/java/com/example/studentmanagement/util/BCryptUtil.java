package com.example.studentmanagement.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {
    // Phương thức này sẽ mã hóa mật khẩu và trả về chuỗi đã được mã hóa
    public static String hashPassword(String plainPassword) {
        // Độ mạnh của BCrypt có thể điều chỉnh bằng cách thay đổi giá trị nIterations
        int nIterations = 12;
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt(nIterations));
        return hashedPassword;
    }

    // Phương thức này sẽ kiểm tra mật khẩu có khớp với mật khẩu đã được mã hóa hay không
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        System.out.println(hashPassword("QuangNN"));
        // $2a$12$vkXRYOHzzK/aE/mOmZw4mujqtnxA2mSx1SXhfCjc/fXw98fWCy4X2
        System.out.println(hashPassword("QuangNN").equals(hashPassword("QuangNN")));

        System.out.println(checkPassword("QuangNN", "$2a$12$0c1no9c8bRob/aocYcbvR.PG2HWEQX4PZ.tphPJL.cUdXDPTP0ixO"));
    }
}

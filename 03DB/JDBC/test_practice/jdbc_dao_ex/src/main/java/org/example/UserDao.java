package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static Connection conn = null;

    static {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/user_ex";
            String id = "root";
            String password = "0000";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);

            if (conn != null) {
                System.out.println("DB  접속 성공");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DB 연결
    public static Connection getConnection() {
        return conn;
    }

    // DB 연결 끊기
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CRUD 메서드

    // C) 회원 생성
    public void create(String email, String password) {
        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0 ) {
                System.out.println("회원 추가 성공");
            } else {
                System.out.println("회원 추가 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // R) 회원 목록 읽기
    public void getAllusers() {
        List<UserVo> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");

                UserVo user = new UserVo(id, email, password);
                userList.add(user);
            }

            userList.forEach((user) -> System.out.println(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // U) 회원 정보 수정
    public void updateUser(int id, String email, String password) {
        String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("회원 정보 수정 성공");
            } else {
                System.out.println("회원 정보 수정 실패~ㅠ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // D) 회원 삭제
    public void deleteUser(int id) {
        String sql =  "DELETE FROM users WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("회원 삭제 성공~!");
            } else {
                System.out.println("회원 삭제 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원의 이름 정보까지 출력 (users + users_info JOIN)
    public void getAllUsersWithName() {
        String sql = "SELECT u.id, i.name, u.email, u.password " +
                "FROM users u " +
                "JOIN users_info i ON u.id = i.id";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String email = rs.getString("email");
                 String password = rs.getString("password");

                 System.out.printf("ID: %d, Name: %s, Email: %s, Password: %s\n", id, name, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // C) 유저 추가
    // 매개변수말고 객체타입을 받아서 하는 버전~
    public void addUser(UserVo newUser) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");
//            if (conn != null) {
//                System.out.println("2. DB 연결 OK");
//            }

            // 여기서부터 진짜루~~///////////////////////////////////////

            // 3. SQL문 생성
            String sql = "INSERT INTO users (email, password) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getPassword());
            System.out.println("3. SQL문 생성 OK");

            //4. SQL문 전송 및 실행
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 추가 성공");
            } else {
                System.out.println("회원 추가 실패");
            }

            //5. 직접 자원 해제 (연걸 끊기)
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // R) 회원 목록 읽기
    public List<UserVo> getAllUsers() {
        List<UserVo> userList = new ArrayList<>();

        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 성공");

            // 3. SQL문 생성
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            System.out.println("3. SQL 문 생성 OK");

            //4. SQL문 전송 및 실행
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // DB연결할때 쓴 변수랑 이름 겹쳐서 userid, userpassword로 변경
                int userid = rs.getInt("id");
                String email = rs.getString("email");
                String userpassword = rs.getString("password");

                UserVo user = new UserVo(userid, email, userpassword);
                userList.add(user);
            }

            //5. 직접 자원 해제 (연걸 끊기)
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 6. 결과 리턴
        return userList;
    }

    // R-2) 특정 회원
    public void getUsers(int userid) {
        UserVo user = null;

        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 성공");

            // 3. SQL문 생성
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);

            // 4. SQL문 전송 및 실행
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                int usersid = rs.getInt("id");
                String email = rs.getString("email");
                String userpassword = rs.getString("password");

                user = new UserVo(usersid, email, userpassword);
                System.out.printf("ID: %d\nEmail: %s\nPassword: %s\n", userid, email, userpassword);
            }
            //5. 직접 자원 해제 (연걸 끊기)
            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // U) 회원 정보 수정
    public void updateUser(UserVo newUser) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            // 3. SQL문 생성

            String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setInt(3, newUser.getId());

            // 4. SQL문 전송 및 실행
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("회원 정보 수정 성공");
            } else {
                System.out.println("회원 정보 수정 실패");
            }

            // 5. 자원 해제
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // D) 회원 정보 삭제
    public void deleteUser(int userid) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            // 3. SQL문 생성
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);

            // 4. SQL문 전송
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("회원 삭제 성공");
            } else {
                System.out.println("회원 삭제 실패");
            }

            // 5. 자원 해제
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getAllUsersWithName - JOIN
    public void getAllUsersWithName() {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. Driver 설정 OK");

            // 2. DB연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0000";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            // 3. SQL문 생성
            String sql = "SELECT u.id, i.name, u.email, u.password FROM users u " +
                    "JOIN users_info i " +
                    "ON u.id = i.id";
            Statement stmt = conn.createStatement();

            // 4. SQL문 전송
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int userid = rs.getInt("id");
                String username = rs.getString("name");
                String email = rs.getString("email");
                String userpassword = rs.getString("password");

                System.out.printf("ID: %d, Email: %s, Password: %s, Name: %s%n", userid, email, userpassword, username);
            }

            // 5. 자원 해제
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

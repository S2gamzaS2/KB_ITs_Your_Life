package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

// 테스트 케이스는 실행되는 순서가 정해져있지 X
// 순서 지정을 위해 TestMethodOrder 사용
// OrderAnnotion : 넘버링 한 순서대로 실행
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    // 테스트 케이스
    @Test
    @DisplayName("새로운 User 등록")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "INSERT INTO USERS (ID, PASSWORD, NAME, ROLE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // DB컴파일
            pstmt.setString(1, "scoula"); // 1부터 시작
            pstmt.setString(2, "scoula123");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count); // 1이면 통과, 아니면 예외 발생
        }
    }

    @Test
    @DisplayName("User 목록 추출")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "SELECT * FROM USERS";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             ) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        }
    }

    @Test
    @DisplayName("특정 User 검색")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 User 수정")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql = "UPDATE USERS SET NAME = ? WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "스콜라 수정");
            pstmt.setString(2, userid);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("특정 User 삭제")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "DELETE FROM USERS WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}

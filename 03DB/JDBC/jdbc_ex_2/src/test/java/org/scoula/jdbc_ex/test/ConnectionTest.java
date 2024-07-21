package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connection 테스트~!!!!
// DB 커넥션은 모듈화해서 쓸거다~!
public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex 데이터베이스 접속 (Connection Test)")
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 연결

        // 설정정보 - 하드코딩(비권장) -> 설정 파일로 분리
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex"; // 연결문자열(접속url)
        String id = "jdbc_ex";
        String password = "jdbc_ex";

        Connection conn = DriverManager.getConnection(url, id, password);
        System.out.println("DB 연결 성공");

        conn.close(); // DB 연결 종료
    }
}

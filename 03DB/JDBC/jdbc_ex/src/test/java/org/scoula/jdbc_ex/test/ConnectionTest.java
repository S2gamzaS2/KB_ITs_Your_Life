package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex 데이터 베이스에 접속한다")
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 설정정보 - 하드코딩 비권장 -> 코드와 분리시키는 게 좋다 (설정파일) => Properties★
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "jdbc_ex";
        String password = "jdbc_ex";

        Connection conn = DriverManager.getConnection(url, id, password);
        System.out.println("DB 연결 성공");
        conn.close();
    }

}

package org.scoula.todo.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// DB 모듈
public class JDBCUtil {
    static Connection conn = null; // static으로 Connection 객체 준비
    static { // conn을 초기화할 코드가 길기 때문에  static 초기화 블럭으로 초기화 진행
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
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
}


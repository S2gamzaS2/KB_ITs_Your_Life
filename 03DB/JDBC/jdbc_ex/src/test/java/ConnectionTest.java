import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//하드코딩
public class ConnectionTest {
//    @Test
//    @DisplayName("jdbc_ex 데이터 베이스에 접속한다") // 테스트 이름
//    public void testConnection() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL과 연결
//
//        // 설정정보 - 하드코딩 비권장 -> 코드와 분리시키는 게 좋다 (설정파일) => Properties★
//        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex"; // 3306번 포트에 mysql 서버
//        String id = "jdbc_ex";
//        String password = "jdbc_ex";
//
//        Connection conn = DriverManager.getConnection(url, id, password);
//        System.out.println("DB 연결 성공");
//        conn.close(); // DB는 반드시 연결을 해제해야 함
//    }

    @Test
    @DisplayName("jdbc_ex에 접속한다.(자동 닫기)")
    public void testConnection2() throws SQLException {
        try(Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB 연결 성공");
        }
    }
}

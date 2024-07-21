package org.scoula.jdbc_ex.common; // JDBCUtil과 동일 패키지

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {

    @Test
    @DisplayName("jdbc_ex에 접속")
    void getConnection() throws SQLException {
        try (Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공쓰~");
        } // catch 없음 -> 예외 처리 안하겠다는 뜻 , 자동 닫기를 하기 위해 try문을 쓴 것
    }
}
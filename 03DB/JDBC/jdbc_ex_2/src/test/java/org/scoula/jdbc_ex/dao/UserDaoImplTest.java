package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoImplTest {
    UserDao dao = new UserDaoImpl();

    @AfterAll // 테스트가 끝날 때마다 JDBC유틸 close
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("User 등록")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO("gamza", "gamza123", "감자", "ADMIN");
        int count = dao.create(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("UserDao User 목록 추출")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> list = dao.getList();
        for (UserVO vo: list) {
            System.out.println(vo);
        }
    }

    @Test
    @DisplayName("특정 User 1건 추출")
    @Order(3)
    void get() throws SQLException {
        // orElseThrow : 데이터가 있으면 리턴, 없으면 예외 던지기
        UserVO user = dao.get("gamza").orElseThrow(NoSuchFieldError::new);
        // Null이 아니어야 한다~ 하지만 위에서 Null이면 이미 예외 던짐ㅋ 여기선 사실 필요 X
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("User 정보 수정")
    @Order(4)
    void update() throws SQLException {
        UserVO user = dao.get("gamza").orElseThrow(NoClassDefFoundError::new);
        user.setName("왕감자");
        int count = dao.update(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("User 삭제")
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("gamza");
        Assertions.assertEquals(1, count);
    }
}
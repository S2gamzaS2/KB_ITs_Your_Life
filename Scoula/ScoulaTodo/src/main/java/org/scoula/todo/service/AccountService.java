package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.UserDao;
import org.scoula.todo.dao.UserDaoImpl;
import org.scoula.todo.domain.UserVO;
import org.scoula.todo.exception.PasswordMissmatchException;
import org.scoula.todo.exception.UsernameDuplicationException;

import java.sql.SQLException;
import java.util.Optional;

// 회원가입
public class AccountService {
    UserDao dao = new UserDaoImpl();

    public void join() {
        try {
            UserVO user = getUser();
            dao.create(user); // 유저 정보 받으면 dao를 이용해 create~
        } catch (UsernameDuplicationException | PasswordMissmatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e); //
        }
    }

    public boolean checkDuplication(String username) throws UsernameDuplicationException, SQLException {
        Optional<UserVO> result = dao.get(username); // username이 있으면 리턴, 없으면 Null
        if (result.isPresent()) { // 데이터가 있으면 ID 중복
            throw new UsernameDuplicationException();
        }
        return false;
    }

    public UserVO getUser() throws SQLException, UsernameDuplicationException, PasswordMissmatchException {
        String username = Input.getLine("사용자 ID: ");
        checkDuplication(username); // 중복 체크

        String password = Input.getLine("비밀번호: ");
        String password2 = Input.getLine("비밀번호 확인: ");
        if (!password.equals(password2)) {
            throw new PasswordMissmatchException();
        }

        String name = Input.getLine("이름: ");
        String role = Input.getLine("역할: ");

        return UserVO.builder()
                .id(username)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
}

package org.scoula.todo.dao;

import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{
    Connection conn = JDBCUtil.getConnection();

    // USERS 테이블 관련 SQL 명령어
    private String USER_LIST = "SELECT * FROM USERS"; // * : UserVO로 맵핑시켜야 함.~
    private String USER_GET = "SELECT * FROM USERS WHERE ID = ?";
    private String USER_INSERT = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
    private String USER_UPDATE = "UPDATE USERS SET NAME = ?, ROLE = ? WHERE ID = ?";
    private String USER_DELETE = "DELETE FROM USERS WHERE ID = ?";

    // 회원 등록
    @Override
    public int create(UserVO user) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(USER_INSERT)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getRole());
            return pstmt.executeUpdate();
        }
    }

    // 목록보기, 상세보기에서 이용함~
    private UserVO map(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user; // VO 객체 리턴~
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getList() throws SQLException {
        // 데이터가 없으면 빈 리스트라도 리턴해야 함 - Null(x) -> 후속 작업으로 루프 돌려야 해서~
        List<UserVO> userList = new ArrayList<UserVO>();

        Connection conn = JDBCUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(USER_LIST);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                UserVO user = map(rs);
                userList.add(user);
            }
        }
        return userList;
    }

    // 회원 정보 조회
    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(USER_GET)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(map(rs)); // UserVO, Optional 데이터가 있음
                }
            }
        }
        return Optional.empty(); // if문 벗어남..~ 데이터 없다,,~ Null~
        // Optional 데이터가 있는지 없는지 확신 x -> Optional.ofNullable(a);
    }

    // 회원 수정
    @Override
    public int update(UserVO user) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(USER_UPDATE)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getRole());
            return pstmt.executeUpdate();
        }
    }

    // USERS 테이블 관련 CRUD 메서드
    // 회원 삭제
    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(USER_DELETE)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate();
        }
    }
}

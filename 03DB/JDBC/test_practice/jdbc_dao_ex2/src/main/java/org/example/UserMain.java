package org.example;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserDao dao = new UserDao();

        // C) UserVo 객체..
//        UserVo newUser = new UserVo(0, "gamza", "1234");
//        dao.addUser(newUser);

        // U)
//        UserVo newUser = new UserVo(7, "kinggamza", "1234");
//        dao.updateUser(newUser);
//        List<UserVo> users = dao.getAllUsers();
//        for(UserVo user: users) {
//            System.out.println(user);
//        }

        // D)
//        dao.deleteUser(7);

        List<UserVo> users = dao.getAllUsers();
        for(UserVo user: users) {
            System.out.println(user); // or  user.getId()..
        }

        // JOIN
        dao.getAllUsersWithName();

    }
}

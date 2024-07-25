package org.example;

import java.sql.Connection;

public class UserMain {
    public static void main(String[] args) {
        UserDao dao = new UserDao();

//        dao.create("gamza", "1234");

//        dao.getAllusers();

//        dao.updateUser(4, "gamza", "1234");
//        dao.getAllusers();
//        dao.deleteUser(4);
//        dao.getAllusers();

        dao.getAllusers();
        dao.getAllUsersWithName();
    }
}

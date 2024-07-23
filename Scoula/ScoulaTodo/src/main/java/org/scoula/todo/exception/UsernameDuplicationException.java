package org.scoula.todo.exception;

// 회원가입 -사용자 ID 중복
public class UsernameDuplicationException extends Exception{
    public UsernameDuplicationException() {
        super("이미 사용중인 사용자 ID 입니다");
    }
}

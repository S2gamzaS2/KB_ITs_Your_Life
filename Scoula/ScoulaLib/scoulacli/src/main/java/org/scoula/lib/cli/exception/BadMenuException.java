package org.scoula.lib.cli.exception;

public class BadMenuException extends Exception {
    public BadMenuException() {
        super("잘못된 메뉴 선택"); // super() -> 부모 생서자 호출
    }

    public BadMenuException(String message) {
        super(message);
    }
}

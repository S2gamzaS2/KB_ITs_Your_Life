package afternoon.exception.real.exceptions;

//체크 예외 클래스를 만들기 위해 Exception 클래스를 상속 받음
public class MyCheckException extends RuntimeException {
    public MyCheckException(String message) {
        super(message);
    }

}

package afternoon.exception.uncheck;


public class Client {
    //던져지는 예외가 언체크 예외이므로 명시적으로 throws 처리 안해도 컴파일 에러발생X
    public void callException() {
        throw new MyUnCheckException("Client.call에서 에러 발생");
    }

    public void callException2() throws MyCheckException {
        throw new MyCheckException("Client.call에서 에러 발생");
    }
}

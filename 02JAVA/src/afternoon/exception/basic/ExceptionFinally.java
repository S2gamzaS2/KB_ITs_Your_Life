package afternoon.exception.basic;

public class ExceptionFinally {
    public static void main(String[] args) {
        try {
            Object obj = null;
            obj.equals(null); //에러: NullPointerException
        } catch (Exception e) {
            e.printStackTrace(); //에러가 어디서부터 시작됐는지 순차적으로 보여줌
        } finally { //꼭 실행해야 하는 프로그램, 예외 발생으로 프로그램이 종료되어도 실행 보장
            System.out.println("정말 실행하고 싶은 코드");
        }

        System.out.println("나오나요?");
    }
}

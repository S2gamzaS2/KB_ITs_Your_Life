package afternoon.exception.basic;

public class ExceptionCatch {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println(arr[5]);
        } catch (Exception e) {
            e.printStackTrace(); //에러가 어디서부터 시작됐는지 순차적으로 보여줌
        }

        System.out.println("나오나요?"); //코드 실행 O
    }
}

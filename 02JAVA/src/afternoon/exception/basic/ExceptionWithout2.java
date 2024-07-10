package afternoon.exception.basic;

public class ExceptionWithout2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        if (accessArr(arr, 5)) {
            System.out.println("배열 접근 가능");
            System.out.println("원하던 작업을 이어갑니다");

            Object obj = null;

            if (!accessNull(obj)) {
                System.out.println("객체가 null이 아닙니다");
                System.out.println("원하던 작업을 이어 갑니다");
            } else {
                System.out.println("객체가 비었습니다, 에러 발생");
            }

        } else {
            System.out.println("배열 접근 불가능, 에러 발생");
        }
    }

    public static boolean accessArr(int[] arr, int idx) {
        if (idx < arr.length) {
            return true;
        } else {
            return false;
        }
    }
    //객체를 매개변수로 받기: 다형성적 의미 - 어떤 객체도 받을 수 있게 (범용적)
    public static boolean accessNull(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }
}

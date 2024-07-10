package afternoon.exception.basic;

public class ExceptionWith {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            accessArr(arr, 5);
            System.out.println("배열 접근이 가능합니다");
            System.out.println("원하는 작업 이어갑니다");

            Object obj = null;

            accessNull(obj);

            System.out.println("객체가 null이 아닙니다");
            System.out.println("원하던 작업을 이어갑니다");

        } catch (Exception e) {
            e.printStackTrace();
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

package afternoon.lang.math;

public class MathMain {
    public static void main(String[] args) {
        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(10, 20));
        System.out.println(Math.abs(-10));
        //올림
        System.out.println(Math.ceil(5.5));
        //내림
        System.out.println(Math.floor(5.5));
        //반올림
        System.out.println(Math.round(5.5));

        //제곱근
        System.out.println(Math.sqrt(9));
        //0 <= rand < 1
        System.out.println(Math.random());
    }
}

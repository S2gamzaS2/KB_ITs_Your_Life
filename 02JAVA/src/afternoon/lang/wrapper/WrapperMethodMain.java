package afternoon.lang.wrapper;

public class WrapperMethodMain {
    public static void main(String[] args) {
        int intvalue = Integer.parseInt("100");
        System.out.println("intvalue = " + intvalue);

        //비교
        Integer a = 10;
        System.out.println(a.compareTo(20));

        //산술연산 (sum: public static int~ )
        System.out.println(Integer.sum(a, intvalue));
        //최소
        System.out.println(Integer.min(10, 20));
        //최대
        System.out.println(Integer.max(20, 30));

    }
}

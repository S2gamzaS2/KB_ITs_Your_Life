package afternoon.operator;

public class Op1 {
    public static void main(String[] args) {
        // 문자 연산의 특이점 1
        String str = "a + b = ";
        int c = 10;

        System.out.println(str + c);

        // 문자 연산의 특이점 2
        int d = 10;
        char e = 'A';
        System.out.println(d + e); //75 , A:65(아스키코드)

    }
}

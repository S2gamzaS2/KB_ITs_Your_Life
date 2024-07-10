package afternoon.operator;

public class Op2 {
    public static void main(String[] args) {
        //문자열 비교
        String str1 = "abc";
        String str2 = "def";
        boolean result1 = str1.equals(str2);
        boolean result2 = "abc".equals(str2);
        boolean result3 = str1.equals("def");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        System.out.println(str1 == str2);
    }
}

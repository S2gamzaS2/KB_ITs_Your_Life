package 문자열;

public class StringExample {
    public static void main(String[] args) {
        //String으로 형변환
        int a = 3;
        float b = 2.5f;
        String num1 = String.valueOf(a);
        String num2 = String.valueOf(b);

        System.out.println(num1.getClass().getName()); // java.lang.String
        System.out.println(num2.getClass().getName()); // java.lang.String

        //char[] -> String
        char[] hello = {'h', 'e', 'l', 'l', 'o'};
        String helloStr = new String(hello);
        System.out.println(helloStr); //hello

        //불변성
        String str = "hello world";
        str = "hello new world";
        System.out.println(str); // hello new world
        // 가르키는 주소 값이 달라지는 것
        String old = "hello world";
        String replaced = old.replace('o', 'a'); // 새 문자열 반환
        System.out.println(replaced); // hella walrd

        // 문자열 비교
        String str1 = "50";
        String str2 = String.valueOf(50);
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true

        // 인덱스 찾기
        String app = "apple";
        int first = app.indexOf('p');
        int last = app.lastIndexOf('p');
        System.out.println("first:" + first + " last:" + last);

        // 문자 변경
        String str3 = "apple";
        String replaced3 = str3.replaceAll("[ap]", "z");
        System.out.println(replaced3);

        // 특정 문자열로 시작? 끝?
        String str4 = "apple";
        System.out.println(str4.startsWith("ap")); // true
        System.out.println(str4.endsWith("l")); // false

    }
}

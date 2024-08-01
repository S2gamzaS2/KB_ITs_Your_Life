package 문자열;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello ");
        sb.append("world!");
        System.out.println(sb); //hello world!

        StringBuilder sb2 = new StringBuilder("initial String"); // 초기값 설정
        System.out.println(sb2); // initial String

        // 순서 반대로
        sb.reverse();
        System.out.println(sb); //!dlrow olleh
        sb.reverse();

        // 특정 인덱스에 문자열 삽입
        StringBuilder sb3 = new StringBuilder("apple");
        sb3.insert(2, "JAVA");
        System.out.println(sb3); // apJAVAple

        // 특정 범위의 문자 삭제
        StringBuilder sb4 = new StringBuilder("Hellappo World!");
        sb4.delete(4, 7);
        System.out.println(sb4); // Hello World!

        // 특정 인덱스의 문자 삭제
        StringBuilder sb5 = new StringBuilder("ABpple");
        sb5.deleteCharAt(1);
        System.out.println(sb5); // Apple

        // 특정 인덱스 문자 교체
        StringBuilder sb6 = new StringBuilder("Hello, borld");
        sb6.setCharAt(7, 'w');
        System.out.println(sb6); // Hello, world

        // 문자열 길이 변경
        StringBuilder sb7 = new StringBuilder("hello world");
        sb7.setLength(5);
        System.out.println(sb7);

        StringBuilder sb8 = new StringBuilder("hello world");
        sb8.setLength(16);
        System.out.println(sb8);



    }
}

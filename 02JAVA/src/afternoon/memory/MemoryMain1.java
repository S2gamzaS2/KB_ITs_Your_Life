package afternoon.memory;

public class MemoryMain1 {
    public static void main(String[] args) {
        //Stack -> 실행 순서 중요
        System.out.println("메인 메서드 시작");
        method1();
        System.out.println("메인 메서드 종료");
    }

    static void method1() {
        System.out.println("메서드1 시작");
        Data data1 = new Data(10);
        method2(data1);
        System.out.println("메서드1 종료");
    }

    static void method2(Data data) {
        System.out.println("메서드2 시작");
        System.out.println("data의 value값: " + data.getValue());
        System.out.println("메서드2 종료");
    }
}

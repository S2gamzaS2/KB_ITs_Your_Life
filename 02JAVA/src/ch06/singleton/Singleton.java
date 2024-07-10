package ch06.singleton;

public class Singleton {
    //필드 선언, 초기화
    private static Singleton singleton = new Singleton();

    //private 접근 권한을 갖는 생성자 선언
    private Singleton() {}

    //public 접근 권한 갖는 메소드 선언
    public static Singleton getInstance() {
        return singleton;
    }

}

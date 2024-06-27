package ch06.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        //정적메소드를 호출해서 싱글톤 객체 얻음
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        //동일 객체 참조인지 확인
        if (obj1 == obj2) {
            System.out.println("동일 객체 참조");
        } else {
            System.out.println("다른 객체 참조");
        }
    }
}

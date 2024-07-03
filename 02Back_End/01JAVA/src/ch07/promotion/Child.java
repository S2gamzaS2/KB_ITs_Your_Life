package ch07.promotion;

public class Child extends Parent {

    //메서드 오버라이딩
    @Override
    public void method2() {
        System.out.println("Child Method 2");
    }

    //메서드 선언
    public void method3() {
        System.out.println("Child Method 3");
    }
}

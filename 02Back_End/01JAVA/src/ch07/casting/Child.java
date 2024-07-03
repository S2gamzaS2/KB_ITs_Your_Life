package ch07.casting;

public class Child extends Parent{
    String childField;

    @Override
    void method2() {
        System.out.println("Child Method 2");
    }

    void method3() {
        System.out.println("Child Method 3");
    }
}

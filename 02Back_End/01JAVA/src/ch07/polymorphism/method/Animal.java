package ch07.polymorphism.method;

public abstract class Animal {

    public void breathe() {
        System.out.println("숨을 쉽니다");
    }

    public abstract void sound();
}

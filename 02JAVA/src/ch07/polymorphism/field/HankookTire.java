package ch07.polymorphism.field;

public class HankookTire extends Tire {
    @Override
    public void roll() {
        System.out.println("한국 Tire 회전");
    }
}

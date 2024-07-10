package afternoon.extendss.supperr;

public class Child extends Parent{
    public String name = "자식클래스 이름";

    @Override
    public void hello() {
        System.out.println("자식클래스: 안녕하슈");
    }

    public void superCall() {
        System.out.println("자신의 이름: " + this.name);
        System.out.println("부모 이름: " + super.name);

        this.hello();
        super.hello();
    }
}

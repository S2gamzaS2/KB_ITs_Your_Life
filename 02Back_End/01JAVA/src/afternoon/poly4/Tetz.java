package afternoon.poly4;

public class Tetz implements Animal, Human{
    @Override
    public void eat() {
        System.out.println("테츠가 밥처럼 제로콜라를 마쉼돠");
    }

    @Override
    public void sleep() {
        System.out.println("테츠는 술 먹으면 잘 좜다");
    }

    @Override
    public void think() {
        System.out.println("테츠가 수업에서 더 웃길지 고민함돠");
    }
}

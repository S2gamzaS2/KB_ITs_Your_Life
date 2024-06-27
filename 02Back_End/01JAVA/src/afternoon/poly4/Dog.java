package afternoon.poly4;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("강아지가 사료를 먹숨돠");
    }

    @Override
    public void sleep() {
        System.out.println("강아지가 꿀잠을 좜돠");
    }
}

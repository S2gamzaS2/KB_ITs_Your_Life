package afternoon.abstractt;

//누군가에게 상속을 하기 위한 클래스, 실체가 없는 클래스
abstract class AbstractAnimal {

    //abstract 클래스 안에만 선언 가능
    //구현X -> 중괄호X
    //오버라이딩 할거면 abstract
    public abstract void sound();

    public abstract void eat();
}

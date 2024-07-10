package afternoon.extendss;
//자식2

//extends 키워드로 상속 받을 부모 클래스 선택
public class GasCar extends Car {

    //어노테이션에 의해서 아래 메소드 검증 (규칙, 타입 등등...~)
    @Override
    public void move() {
        System.out.println("기름차가 이동합니다");
    }

    @Override
    public void openDoor() {
        System.out.println("기름차 문을 엽니다");
    }

    public void fillUp() {
        System.out.println("기름차가 주유합니다");
    }
}

package afternoon.extendss;
//자식1

//extends 키워드로 상속 받을 부모 클래스 선택
//같은 패키지여서 import X
public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("전기차가 이동합니다");
    }

    @Override
    public void openDoor() {
        System.out.println("전기차 문이 열립니다");
    }

    public void charge() {
        System.out.println("전기차를 충전합니다");
    }
}

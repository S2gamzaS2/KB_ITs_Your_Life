package afternoon.extendss;

public class HydrogenCar extends Car {

    @Override
    public void move() {
        System.out.println("수소차가 이동합니다");
    }

    @Override
    public void openDoor() {
        System.out.println("수소차 문이 열립니다");
    }

    public void fillHydrogen() {
        System.out.println("수소 충전을 삐리빠리뽀");
    }

}

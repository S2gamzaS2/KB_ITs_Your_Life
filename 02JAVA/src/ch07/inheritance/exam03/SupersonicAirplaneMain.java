package ch07.inheritance.exam03;

public class SupersonicAirplaneMain {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();

        sa.takeOff();
        sa.fly(); //부모 비행
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly(); //자식 비행
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly(); //부모 비행
        sa.land();
    }
}

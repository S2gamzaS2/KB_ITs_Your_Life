package ch07.inheritance.exam03;

public class SupersonicAirplane extends Airplane{

    //상수 선언
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    //상태 필드 선언
    public int flyMode = NORMAL;

    //매소드 재정의

    @Override
    public void fly() {
        if (flyMode == SUPERSONIC) {
            System.out.println("초음속 비행~");
        } else {
            //Airplane 객체의 fly() 호출
            super.fly();
        }
    }
}

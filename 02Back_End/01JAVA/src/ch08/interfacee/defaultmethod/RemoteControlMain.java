package ch08.interfacee.defaultmethod;

public class RemoteControlMain {
    public static void main(String[] args) {
        //인터페이스 변수 선언
        RemoteControl rc;

        //Television 객체 생성 - 인터페이스 변수에 대입
        rc = new Television();
        rc.turnOn();
        rc.setVolume(15);
        //디폴트 메서드
        rc.setMute(true);
        rc.setMute(false);
        rc.turnOff();
        System.out.println();

        //Audio 객체를 생성 - 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        //디폴트메서드
        rc.setMute(true);
        rc.setMute(false);
        rc.turnOff();
    }
}

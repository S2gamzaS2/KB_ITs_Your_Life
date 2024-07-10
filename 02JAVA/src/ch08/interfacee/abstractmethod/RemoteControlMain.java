package ch08.interfacee.abstractmethod;

public class RemoteControlMain {
    public static void main(String[] args) {
        //인터페이스 변수 선언
        RemoteControl rc;

        //Television 객체 생성 - 인터페이스 변수에 대입
        rc = new Television();
        rc.turnOn();
        rc.setVolume(15);
        rc.turnOff();

        //Audio 객체를 생성 - 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();
    }
}

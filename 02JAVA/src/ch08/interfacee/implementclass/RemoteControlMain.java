package ch08.interfacee.implementclass;

public class RemoteControlMain {
    public static void main(String[] args) {
        RemoteControl rc = new Television();
        RemoteControl rc2 = new Audio();

        rc.turnOn();
        rc2.turnOn();
    }
}

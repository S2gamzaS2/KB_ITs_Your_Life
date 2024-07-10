package ch08.interfacee.implementclass;

public class Television implements RemoteControl{
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니돠");
    }
}

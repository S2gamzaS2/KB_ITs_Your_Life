package ch08.interfacee.multi;

public class SmartTelevisionMain {
    public static void main(String[] args) {
        RemoteControl rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        Searchable searchable = new SmartTelevision();
        searchable.search("naver.com");
    }
}

package ch08.interfacee.multi;

public class SmartTelevision implements RemoteControl, Searchable{
    //추상 메서드 오버라이딩
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다");
    }
    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다");
    }
    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다");
    }
}

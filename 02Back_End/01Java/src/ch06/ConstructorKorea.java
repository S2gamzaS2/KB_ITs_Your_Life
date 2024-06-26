package ch06;

public class ConstructorKorea {
    String nation = "대한민국";
    String name;
    String ssn;

    //생성자 빨리 만들기~ => Alt + Insert - Constructor
    public ConstructorKorea(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}

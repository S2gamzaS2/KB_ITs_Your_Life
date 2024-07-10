package ch07.inheritance.exam02;

public class SmartPhone extends Phone{

    //자식생성자 선언

    public SmartPhone(String model, String color) {
        super(model, color); //반드시 작성해야함- 생략하면 super(); 불러옴
        System.out.println("SmartPhone 생성자 실행");
    }
}

package ch07.inheritance.exam02;

//부모클래스가 매개변수를 갖는 생성자
public class Phone {

    //필드 선언
    public String model;
    public String color;

    //매개변수를 갖는 생성자 선언
    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("Phone 생성자 실행");
    }
}

package ch07.inheritance.exam01;

public class SmartPhoneMain {
    public static void main(String[] args) {

        //SmartPhone 객체 생성
        SmartPhone myPhone = new SmartPhone("갤럭시", "블랙");

        //Phone으로부터 상속받은 필드 읽기
        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);
    }
}

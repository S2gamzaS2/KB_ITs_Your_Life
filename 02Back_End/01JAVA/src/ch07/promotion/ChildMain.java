package ch07.promotion;

public class ChildMain  {
    public static void main(String[] args) {

        //자식 객체 생성
        Child child = new Child();

        //자동 타입 변환
        Parent parent = child;

        //메서드 호출
        parent.method1(); //Parent Method 1
        parent.method2(); //Child Method 2
//        parent.method3(); -> 호출 불가능, 에러
    }
}

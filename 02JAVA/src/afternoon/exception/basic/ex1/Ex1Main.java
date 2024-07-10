package afternoon.exception.basic.ex1;

public class Ex1Main {
    //중첩클래스
    static class Parent{};
    static class Child extends Parent{
        void childMethod() {
            System.out.println("Child.childMethod");
        }
    };
    public static void main(String[] args) {
        try{
            Parent parent = new Parent();
            Child poly = (Child) parent;
            poly.childMethod(); //에러
        } catch (ClassCastException e) {
            System.out.println("예외 처리 완료!");
            e.printStackTrace();
        }
    }
}

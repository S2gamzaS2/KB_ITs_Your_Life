package afternoon.poly3.casting1;

public class PolyMain1 {
    public static void main(String[] args) {
        Child child = new Child();

        child.childMethod();
        child.parentMethod();

        //타입은 Parent, 인스턴스는 Child
        Parent parent = new Child();

        //Parent->Child 형변환
        ((Child) parent).childMethod();

    }
}

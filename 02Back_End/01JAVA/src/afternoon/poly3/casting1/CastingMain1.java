package afternoon.poly3.casting1;

public class CastingMain1 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = child; //업캐스팅이 숨겨져있음
        Parent parent2 = (Parent) child; //동일한 코드
    }
}

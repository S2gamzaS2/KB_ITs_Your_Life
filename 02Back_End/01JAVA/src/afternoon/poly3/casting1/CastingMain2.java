package afternoon.poly3.casting1;

public class CastingMain2 {
    //#1번코드
    Parent parent1 = new Child();
    Child child1 = (Child) parent1;

    //#2번코드-에러
    Parent parent2 = new Parent();
    Child child2 = (Child) parent2;
}

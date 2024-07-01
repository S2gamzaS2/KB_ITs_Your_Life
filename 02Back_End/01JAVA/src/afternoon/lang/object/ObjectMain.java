package afternoon.lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();

        child.childMethod();
        child.parentMethod();

        //toString(): Object 안에 있음
        //결과 값이 같은 이유: println이 인스턴스 내부의 toString을 실행시키기 때문
        System.out.println(child.toString());
        System.out.println(child);

        //hashCode: 주소값
        //10진수 -> 16진수
        String ref1 = Integer.toHexString(child.hashCode());
        String ref2 = Integer.toHexString(System.identityHashCode(child));

        //같은 참조값
        System.out.println("ref1 = " + ref1);
        System.out.println("ref2 = " + ref2);

        Parent[] objects = {new Parent(), new Child()};
        //모든 클래스는 기본적으로 Object 상속
        Object[] objects1 = {new Parent(), new Child(), new OtherClass()};

        System.out.println(size(objects1));
    }
    public static int size(Object[] objects) {
        return objects.length;
    }
}

package afternoon.nested.nested;

public class Outer {
    private static String outerStatic = "outerStatic";
    private String outerInstance = "outerInstance";

    //중첩: static 붙여~
    static class Nested {
        private static String nestedStatic = "nestedStatic";
        private String nestedInstance = "nestedInstance";

        public void print() {
            //클래스 내부의 static에 접근 -> print와 nestedStatic이 같은 클래스 안이라 접근 가능
            System.out.println("nestedStatic = " + nestedStatic);
            //내부 클래스도 결국 같은 클래스라 접근 가능
            System.out.println("outerStatic = " + outerStatic);

            //클래서 내부의 non-static(인스턴스)에 접근
            System.out.println("nestedInstance = " + nestedInstance);
            //outerInstance 접근 X : 인스턴스가 생성되었을 때 상속이 아니라 별개의 인스턴스.. 주소 모름
            //System.out.println("outerInstance = " + outerInstance);

        }
    }
}

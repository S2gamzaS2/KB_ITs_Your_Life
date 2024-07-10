package afternoon.nested.inner;

public class Outer {
    private static String outerStatic = "outerStatic";
    private String outerInstance = "outerInstance";

    //내부클래스: static x
    class Inner {
        private static String nestedStatic = "nestedStatic";
        private String nestedInstance = "nestedInstance";

        public void print() {
            //클래스 내부의 static에 접근 -> print와 nestedStatic이 같은 클래스 안이라 접근 가능
            System.out.println("nestedStatic = " + nestedStatic);
            //내부 클래스도 결국 같은 클래스라 접근 가능
            System.out.println("outerStatic = " + outerStatic);

            //클래서 내부의 non-static(인스턴스)에 접근
            System.out.println("nestedInstance = " + nestedInstance);
            //가넝
            System.out.println("outerInstance = " + outerInstance);

        }
    }
}

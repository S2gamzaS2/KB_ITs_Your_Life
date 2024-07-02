package afternoon.nested.inner.ex3;

public class OuterClass2Main {
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass innerClass = outerClass2.new InnerClass();

        //위에랑 같은 표현
//        OuterClass2.InnerClass innerClass = new OuterClass2().new InnerClass();

        innerClass.hello();

    }
}

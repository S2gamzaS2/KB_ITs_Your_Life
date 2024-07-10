package afternoon.nested.local.ex2;

public class OuterClass3 {
    public void myMethod() {
        class LocalClass {
            public void hello() {
                System.out.println("안녕하세요 지역클래스의 hello입니다");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.hello();
    }
}

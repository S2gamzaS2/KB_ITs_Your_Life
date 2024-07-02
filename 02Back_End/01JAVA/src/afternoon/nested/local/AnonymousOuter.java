package afternoon.nested.local;

public class AnonymousOuter {
    private String outerInstance = "outerInstance";

    public void outerMethod(String methodParameter) {
        String methodString = "methodString";

        Print print = new Print() {
            String localInstance = "localInstance";

            @Override
            public void printLocal() {
                System.out.println("outerInstance = " + outerInstance);
                System.out.println("methodString = " + methodString);
                System.out.println("methodParameter = " + methodParameter);
                System.out.println("localInstance = " + localInstance);
            }
        };

        print.printLocal();
    }

    //운영클래스 같이할 수도 있음냐
    public static void main(String[] args) {
        AnonymousOuter localOuter = new AnonymousOuter();
        localOuter.outerMethod("methodParameter");
    }
}

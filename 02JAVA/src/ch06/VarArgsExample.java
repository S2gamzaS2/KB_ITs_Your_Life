package ch06;

public class VarArgsExample {
    public static void main(String[] args) {

        //VarArgs 객체 생성
        VarArgs myVar = new VarArgs();

        int result1 = myVar.sum(1, 2, 3);
        System.out.println(result1);

        //배열 자체를 넘길 수 있음
        int[] values = {1, 2, 3, 4, 5};
        int result2 = myVar.sum(values);
        System.out.println(result2);
    }
}

package ch06;

public class VarArgs {

    //가변길이 매변수를 갖는 메소드 선언
    int sum(int ... values) {
        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }

        return sum;
    }

}

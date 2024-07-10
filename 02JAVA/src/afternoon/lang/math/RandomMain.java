package afternoon.lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random();

        //int 범위의 + - 정수
        System.out.println(random.nextInt());
        //0~1.0 소수
        System.out.println(random.nextDouble());
        //T, F 랜덤
        System.out.println(random.nextBoolean());

        //0~(100-1)까지 나옴
        System.out.println(random.nextInt(100));
    }
}

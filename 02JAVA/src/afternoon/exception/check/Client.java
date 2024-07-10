package afternoon.exception.check;

import java.util.Random;

public class Client {
    public void callException() throws MyCheckException {
        throw new MyCheckException("Client.call에서 에러 발생");
    }

    public void callRandException() throws MyCheckException2 {
        Random rand = new Random();
        boolean luck = rand.nextBoolean();

        if (luck) {
            throw new MyCheckException2("오늘은 운이 업으시군요");
        } else {
            System.out.println("오늘은 운이 좋으시군");
        }
    }
}

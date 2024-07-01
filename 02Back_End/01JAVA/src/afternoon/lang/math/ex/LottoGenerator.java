package afternoon.lang.math.ex;

import java.util.Random;

public class LottoGenerator {
    Random rand = new Random();

    int[] lottoNumbers = new int[6];


    public void generate() {
        for(int i = 0; i < 6; i++) {
            lottoNumbers[i] = rand.nextInt(45) + 1;
        }
    }

    public void printLottoNumbers() {
        System.out.print("로또 번호: ");
        for(int r: lottoNumbers) {
            System.out.print(r + " ");
        }
    }
}

package afternoon.nested.local.ex1;

import java.util.Random;

public class Ex5Main {
    public static void main(String[] args) {
        Dice diceOnce = new Dice() {
            @Override
            public void run() {
                int rand = new Random().nextInt(6) + 1;
                System.out.println("주사위 값은: " + rand);
            }
        };
        Dice diceSum = new Dice() {
            @Override
            public void run() {
                int rand1 = new Random().nextInt(6) + 1;
                int rand2 = new Random().nextInt(6) + 1;
                int sum = rand1 + rand2;
                System.out.println("첫 번째 주사위: " + rand1 + " / 두 번째 주사위: " + rand2);
                System.out.println("주사위를 두 번 굴린 값의 합은: " + sum);
            }
        };
    }

    public static void main(String[] args) {
        complicatedProgram(new DiceOnce());
        complicatedProgram(new DiceSum());
    }
}

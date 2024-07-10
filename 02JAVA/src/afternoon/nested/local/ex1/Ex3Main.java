package afternoon.nested.local.ex1;

import java.util.Random;

public class Ex3Main {
    public static void complicatedProgram(Dice dice) {
        System.out.println("복잡한 과정 시작");
        System.out.println("복잡한 과정 종료 후, 원하는 기능 실행");

        //코드 덩어리 시작
        dice.run();
        //코드 덩어리 종료

        System.out.println("복잡한 과정 다시 시작");
        System.out.println("복잡한 과정 종료 후, 프로그램 종료");
    }

    class DiceOnce implements Dice {
        @Override
        public void run() {
            int rand = new Random().nextInt(6) + 1;
            System.out.println("주사위 값은: " + rand);
        }
    }

    class DiceSum implements Dice {
        @Override
        public void run() {
            int rand1 = new Random().nextInt(6) + 1;
            int rand2 = new Random().nextInt(6) + 1;
            int sum = rand1 + rand2;
            System.out.println("첫 번째 주사위: " + rand1 + " / 두 번째 주사위: " + rand2);
            System.out.println("주사위를 두 번 굴린 값의 합은: " + sum);
        }
    }

    public static void main(String[] args) {
        Ex3Main ex3 = new Ex3Main();
        complicatedProgram(ex3.new DiceOnce());
        complicatedProgram(ex3.new DiceSum());
    }
}

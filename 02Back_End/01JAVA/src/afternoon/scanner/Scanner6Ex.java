package afternoon.scanner;
import java.util.Scanner;

public class Scanner6Ex {
    public static void main(String[] args) {
        int rand_num = (int)(Math.random()*100);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("랜덤 숫자를 입력하세요: ");
            int num = sc.nextInt();

            if (num > rand_num) {
                System.out.println("Down");
            } else if (num < rand_num) {
                System.out.println("Up");
            } else {
                System.out.println("정답입니다! 랜덤 숫자는 " + rand_num);
                break;
            }
        }
    }
}

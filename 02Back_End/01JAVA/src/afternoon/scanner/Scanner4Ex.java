package afternoon.scanner;

import java.util.Scanner;

public class Scanner4Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 정수: ");
        int num1 = scanner.nextInt();
        System.out.print("두 번째 정수: ");
        int num2 = scanner.nextInt();

        if (num1 < num2) {
            int sum = 0;
            for (int i = num1 ; i <= num2 ; i++) {
                sum += i;
            }
            System.out.println("합: " + sum);
        } else {
            System.out.println("첫 번째 정수가 더 큽니다~");
        }
    }
}

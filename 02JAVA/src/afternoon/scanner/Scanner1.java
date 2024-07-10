package afternoon.scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요: ");
        String str = scanner.nextLine(); //문자로 받기
        System.out.println("입력한 문자열은?!: " + str);

        System.out.print("정수를 입력하세요: ");
        int number = scanner.nextInt(); //정수로 받기
        System.out.println("입력한 정수는?!: " + number);

    }
}

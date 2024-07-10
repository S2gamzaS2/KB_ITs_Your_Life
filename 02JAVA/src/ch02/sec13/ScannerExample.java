package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x값 입력>> ");
        String strX = sc.nextLine();
        int x = Integer.parseInt(strX);

        System.out.print("y값 입력>> ");
        String strY = sc.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.printf("x + y = %d\n", result);

        //---------------

        while(true) {
            System.out.print("입력문자열>> ");
            String data = sc.nextLine();

            if (data.equals("Q")) {
                break;
            }

            System.out.printf("출력문자열: %s\n", data);

        }
            System.out.println("종료");
    }
}

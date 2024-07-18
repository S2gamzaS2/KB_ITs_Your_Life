package v2_v3;

import java.util.Scanner;

// 입력 클래스
// 인스턴스 안 만들고 그냥 운영하는 클래스
public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String title) {
        System.out.print(title);
        return Integer.parseInt(scanner.nextLine());
    }
}

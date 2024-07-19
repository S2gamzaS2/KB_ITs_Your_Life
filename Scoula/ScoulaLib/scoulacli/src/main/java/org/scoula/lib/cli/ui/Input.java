package org.scoula.lib.cli.ui;

import java.util.Scanner;

// 입력 클래스
// 인스턴스 안 만들고 그냥 운영하는 클래스
public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String title) {
        System.out.print(title);
        return Integer.parseInt(scanner.nextLine());
    }

    // String 추가
    public static String getLine(String title) {
        System.out.print(title);
        return scanner.nextLine();
    }

    // getLine 추가 수정
    public static String getLine(String title, String defaultValue) {
        // 이름(김길동):
        System.out.printf("%s(%s): ", title, defaultValue);
        String answer = scanner.nextLine();

        // 그냥 엔터 쳤으면 defaultValue 리턴, 입력값 있으면 answer 리턴
        return answer.isEmpty() ? defaultValue : answer;
    }

    // boolean 입력 (완료 여부)
    // 타이틀만 주었을 경우 - true(Default)
    public static boolean confirm(String title) {
        return confirm(title, true); // 아래 confirm 메서드
    }
    // false
    public static boolean confirm(String title, boolean defaultValue) {
        String yesNo = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.printf("%s %s: ", title, yesNo);

        String answer = scanner.nextLine();
        if (answer.isEmpty())
            return defaultValue;

        return answer.equalsIgnoreCase("y"); // IgnoreCase: 대소문자 구분 없이 비교
    }
}

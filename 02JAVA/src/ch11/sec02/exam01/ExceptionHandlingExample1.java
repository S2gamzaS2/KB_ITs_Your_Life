package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {

        // 14번째 줄에서 null을 전달하여, null.length가 실행되어 NullPointerException 발생
        int result = data.length();
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); //null을 printLength에 전달하여 에러 유발

        System.out.println("[프로그램 종료]");
    }
}


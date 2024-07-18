package v1;

import java.util.Scanner;

public class App_V1 {
    boolean run = true;
    int studentNum = 0;
    int[] scores = null; //학생수 입력 받아서 배열 크기 정함

    Scanner scanner = new Scanner(System.in);

    // 1. 메뉴 출력
    public void printMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
        System.out.println("-------------------------------------------------");
    }

    // 2. 선택
    public int getSelect() {
        System.out.print("선택> ");
        return Integer.parseInt(scanner.nextLine());
    }

    // 3. 학생수
    public void getStudentNum() {
        System.out.print("학생수> ");
        studentNum = Integer.parseInt(scanner.nextLine());
        scores = new int[studentNum];
    }
    // 4. 점수 입력
    public void getScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.print("scores[" + i + "]> ");
            scores[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    // 5. 점수 리스트
    public void printScore() {
        for (int i = 0; i <scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

    // 6. 분석
    public void analize() {
        int max = 0;
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < scores.length; i++) {
            max = (max < scores[i]) ? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentNum;
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }

    // 7. 프로그램 종료
    public void exit() {
        run = false;
    }

    // 8. 메뉴 선택
    public void executeCommand (int selectNo) {
        if (selectNo == 1) {
            getStudentNum();
        } else if (selectNo == 2) {
            getScores();
        } else if (selectNo == 3) {
            printScore();
        } else if (selectNo == 4) {
            analize();
        } else if (selectNo == 5) {
            exit();
        }
    }

    // 9. 운영 - 흐름제어
    public void run() {
        while (run) {
            printMenu();
            int selectNo = getSelect();
            executeCommand(selectNo);
        }
        System.out.println("프로그램 종료");
    }

    // 해당 클래스를 인스턴스화
    public static void main(String[] args) {
        App_V1 app = new App_V1();
        app.run();
    }
}

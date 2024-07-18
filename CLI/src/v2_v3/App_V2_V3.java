package v2_v3;

public class App_V2_V3 {
    int studentNum = 0;
    int[] scores = null;

    // printMenu(), getSelect() 제거 -> Menu 클래스가 담당
    Menu menu;
    public App_V2_V3() {
        menu = new Menu();
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
        while (true) {
            menu.printMenu();
            int selectNo = menu.getSelect();
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

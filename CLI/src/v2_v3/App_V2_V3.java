package v2_v3;

import v2_v3.command.*;

public class App_V2_V3 {
    // printMenu(), getSelect() 제거 -> Menu 클래스가 담당
    Menu menu;
    Command[] commands;

    // if 구문 제거 -> Command 객체 사용
    public App_V2_V3() {
        menu = new Menu();
        // command 배열에 메뉴들 넣기
        commands = new Command[] {
                new InitScoresCommand(),
                new GetScoresCommand(),
                new PrintScoreCommand(),
                new AnalizeCommand(),
                new ExitCommand()
        };
    }
    public void executeCommand(int selectNo) {
        Command command = commands[selectNo - 1];
        command.execute(); // Command 패턴
    }

    // 운영 - 흐름제어
    public void run() {
        while (true) {
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
        }
    }


    // 해당 클래스를 인스턴스화
    public static void main(String[] args) {
        App_V2_V3 app = new App_V2_V3();
        app.run();
    }
}

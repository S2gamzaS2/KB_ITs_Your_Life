package v4;

import v4.command.*;
import v4.ui.Menu;
import v4.ui.MenuItem;

public class App_V4 {
    Menu menu;

    public App_V4() {
    }

    public void init(int menuSize) {
        menu = new Menu(menuSize);
        createMenu(menu);
    }

    public void createMenu(Menu menu) {
        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
        menu.add(1, new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(2, new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(3, new MenuItem("분석", new AnalizeCommand()));
        menu.add(4, new MenuItem("종료", new ExitCommand()));
    }

    public void run() {
        init(5);
        while(true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }

    public static void main(String[] args) {
        App_V4 app = new App_V4();
        app.run();
    }

}

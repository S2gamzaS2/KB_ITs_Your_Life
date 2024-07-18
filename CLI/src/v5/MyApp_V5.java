package v5;

import v5.command.*;
import v5.ui.Menu;
import v5.ui.MenuItem;

public class MyApp_V5 extends App_V5{
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
        menu.add(1, new MenuItem("점수 입력", new GetScoresCommand()));
        menu.add(2, new MenuItem("점수 리스트", new PrintScoreCommand()));
        menu.add(3, new MenuItem("분석", new AnalizeCommand()));
        menu.add(4, new MenuItem("종료", new ExitCommand()));
    }

    public static void main(String[] args) {
        App_V5 app = new MyApp_V5();
        app.init(5);
        app.run();
    }
}

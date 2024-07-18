package v6;

import v6.command.*;
import v6.ui.Menu;
import v6.ui.MenuItem;

public class MyApp_V6 extends App_V6 {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);
        menu.add(new MenuItem("학생수", new InitScoresCommand()));
        menu.add(new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(new MenuItem("분석", new AnalizeCommand()));
    }

    public static void main(String[] args) {
        App_V6 app = new MyApp_V6();
        app.run();
    }
}

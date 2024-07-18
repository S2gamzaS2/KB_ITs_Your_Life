package v6;

import v6.command.Command;
import v6.command.ExitCommand;
import v6.ui.Menu;
import v6.ui.MenuItem;

// 추상클래스
public abstract class App_V6 {
    Menu menu;

    public App_V6() {

    }

    public void init() {
        menu = new Menu();
        createMenu(menu);
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    // ★아무일도 안함 - 부모는 형태만 잡는다~! => 자식이 오버라이딩 (커스터마이징)
    public void createMenu(Menu menu) {

    }

    public void run() {
        init();
        while(true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}

package org.scoula.lib.cli;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.command.ExitCommand;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    Menu menu;

    public App() {

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


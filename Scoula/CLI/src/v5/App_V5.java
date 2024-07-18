package v5;

import v5.command.Command;
import v5.ui.Menu;

// 추상클래스
public abstract class App_V5 {
    Menu menu;

    public App_V5() {}

    public void init(int menuSize) {
        menu = new Menu(menuSize);
        createMenu(menu);
    }

    // ★아무일도 안함 - 부모는 형태만 잡는다~! => 자식이 오버라이딩 (커스터마이징)
    public void createMenu(Menu menu) {

    }

    public void run() {
        //init(5); 제거
        while(true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}

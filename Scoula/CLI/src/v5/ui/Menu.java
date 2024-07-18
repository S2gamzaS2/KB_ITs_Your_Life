package v5.ui;

import v5.Input;
import v5.command.Command;

// 메뉴 클래스 일반화
public class Menu {
    MenuItem[] menus;

    public Menu(int size) {
        menus = new MenuItem[size];
    }

    // ★메뉴 항목 주입 (DI)
    public void add(int idx, MenuItem item) {
        menus[idx] = item;
    }

    public void printMenu() {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d.%s | ", i + 1, menus[i].getTitle());
        }
        System.out.println();
        System.out.println("-------------------------------------------------");
    }

    // Command 리턴
    public Command getSelect() {
        int selectNo = Input.getInt("선택> ");

        return menus[selectNo - 1].getCommand();
    }
}

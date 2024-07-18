package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public class TodoApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        // 번호를 입력해도 에러는 나지만 프로그램 종료는 X -> 예외처리 했기 때문
        menu.add(new MenuItem("목록", null)); // Command 객체 아직 준비 x -> Null
        menu.add(new MenuItem("상세", null));
        menu.add(new MenuItem("추가", null));
        menu.add(new MenuItem("수정", null));
        menu.add(new MenuItem("삭제", null));
        // 현재는 6.종료만 정상 실행
    }

    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}

package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.todo.command.*;

public class TodoApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        // 번호를 입력해도 에러는 나지만 프로그램 종료는 X -> 예외처리 했기 때문
        menu.add(new MenuItem("목록", new PrintTodoCommand()));
        menu.add(new MenuItem("상세", new DetailTodoCommand()));
        menu.add(new MenuItem("추가", new AddTodoCommand()));
        menu.add(new MenuItem("수정", new UpdateTodoCommand()));
        menu.add(new MenuItem("삭제", new DeleteTodoCommand()));
        // 6. 프로그램 종료
    }

    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}

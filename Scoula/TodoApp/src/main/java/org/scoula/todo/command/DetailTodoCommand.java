package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

// 상세보기
public class DetailTodoCommand implements Command {
    TodoDao dao = TodoListDao.getInstance(); // Dao

    @Override
    public void execute() {
        int id = Input.getInt("Todo Id: "); // 에러1) id 입력 받을 때 - 숫자가 아닌 것을 입력했을 때
        Todo todo = dao.getTodo(id); // 에러2) 존재하지 않는 id를 입력 했을 때 - Null - NullPointException 발생

        System.out.println("[Todo 상세보기]-----------------------");
        System.out.println("ID     : " + todo.getId());
        System.out.println("제목    : " + todo.getTitle());
        System.out.println("설명    : " + todo.getDescription());
        System.out.println("완료여부 : " + todo.isDone());
        System.out.println("등록일   : " + todo.getRegDate());
        System.out.println("------------------------------------");
        System.out.println();
    }
}

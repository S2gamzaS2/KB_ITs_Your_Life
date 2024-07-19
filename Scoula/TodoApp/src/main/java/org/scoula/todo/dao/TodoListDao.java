package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListDao implements TodoDao {
    // 싱글톤 패턴
    private static TodoListDao instance = new TodoListDao();

    public static TodoDao getInstance() {
        return instance;
    }

    private List<Todo> list; // 리스트를 사용해서 운영

    private TodoListDao() {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++) { // 임시 테스트 구성
            Todo todo = Todo.builder()
                    .title("Todo " + i)
                    .description("Description " + i)
                    .done(false)
                    .build();
            list.add(todo);
        }
    }

    // 리스트에 대한 CRUD
    // C : 추가
    // R : 목록read, 하나read
    // U : 교체
    // D : 리스트에서 제거

    @Override
    public List<Todo> getList() {
        return list;
    }

    // 단일 element 읽기
    @Override
    public Todo getTodo(int id) {
        for(Todo todo: list) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    // 추가
    @Override
    public void add(Todo todo) {
        list.add(todo);
    }

    // 업데이트
    @Override
    public void update(Todo todo) {
        for(int i = 0; i < list.size(); i++) {
            if(todo.getId() == list.get(i).getId()) {
                list.set(i, todo);
            }
        }
    }

    // 삭제
    @Override
    public void delete(int id) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                list.remove(i);
                return;
            }
        }
    }
}

package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.List;

// TodoDao 인터페이스 자동 생성 완
public interface TodoDao {
    List<Todo> getList();

    // 단일 element 읽기
    Todo getTodo(int id);

    // 추가
    void add(Todo todo);

    // 업데이트
    void update(Todo todo);

    // 삭제
    void delete(int id);
}

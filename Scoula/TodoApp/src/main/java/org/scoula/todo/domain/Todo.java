package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
// lombok
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 얘네를 다 받아줌
@Data // getter, setter 다 포함 ...
public class Todo implements Cloneable{ // 복제(clone)을 허용하는 인터페이스
    private static int gid = 1; // Todo ID 발급을 위한 스태틱 변수 (유일한 정수값), 일종의 ID 발급기^_^

    // 멤버 정의
    private int id;
    private String title;
    private String description;
    private boolean done;
    private Date date;

    @Builder // 이 생성자에 준해서 Builder를 운영
    // 호출 할 수 있는 설정: title(), description(), done() / id, date에 대해서는 Building 못함
    public Todo (String title, String description, boolean done) {
        this(gid++, title, description, done, new Date());
    }
}

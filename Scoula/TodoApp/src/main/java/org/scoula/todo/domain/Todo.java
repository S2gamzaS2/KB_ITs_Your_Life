package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
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

    @Builder // 생성자 레벨에 붙인 Builder -> 이 생성자에 준해서 Builder를 운영
    // 호출 할 수 있는 설정: title(), description(), done() / id, date에 대해서는 Building 못함
    public Todo (String title, String description, boolean done) {
        this(gid++, title, description, done, new Date());
    }

    @Override
    // 부모에서는 protect 였던 것을 public으로 변경
    // return은 Object
    // 실제 사용시에는 down casting 해야 함
    // 반드시 Cloneable 인스턴스를 구현한 객체만 clone 호출 가능
    public Object clone() {
         try {
            return super.clone();
         } catch (CloneNotSupportedException e) {
             throw new RuntimeException(e);
         }
    }

    // 문자열로 날짜를 리턴
    public String getRegDate() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 패턴 문자열
        return sdf.format(date);
    }
}

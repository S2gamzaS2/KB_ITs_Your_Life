package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO객체 만들기
@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
@Builder
public class UserVO {
    // 컬럼들..~
    private String id;
    private String password;
    private String name;
    private String role;
}

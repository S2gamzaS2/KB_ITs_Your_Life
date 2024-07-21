package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO객체 만들기
@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
public class UserVO {
    // 컬럼들..~
    private String id;
    private String password;
    private String name;
    private String role;
}

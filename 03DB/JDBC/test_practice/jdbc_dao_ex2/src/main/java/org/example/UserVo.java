package org.example;

import java.util.Objects;

// 롬복 없이 하려고~ 만든다~^_^
public class UserVo {
    // ★ 테이블 보고 잘 입력
    // 시간: TimeStamp
    int id;
    String email;
    String password;

    // @AllArgsConstructor
    public UserVo(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // Getter, Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return id == userVo.id && Objects.equals(email, userVo.email) && Objects.equals(password, userVo.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}

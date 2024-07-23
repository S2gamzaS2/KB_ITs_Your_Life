package org.example;

public class UserVo {
    private int id;
    private String email;
    private String password;

    // 기본 생성자 @NoArgsConstructor
    public UserVo(int id) {
        this.id = id;
    }

    // 전체 생성자 @AllArgsConstructor
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
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder @Builder
    public static class Builder {
        private int id;
        private String email;
        private String password;

        public Builder() {}

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserVo build() {
            return new UserVo(id, email, password);
        }
    }
}

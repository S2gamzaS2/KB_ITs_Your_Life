package org.scoula.dynamicweb.dto;

//기본생성자, getter, setter
public class LoginDTO {
    private String id;
    private String passwd;

    public LoginDTO() {
    }

    public LoginDTO(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

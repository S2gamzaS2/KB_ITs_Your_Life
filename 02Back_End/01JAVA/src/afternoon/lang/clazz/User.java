package afternoon.lang.clazz;

//extends Object 생략 (모든 클래스는 Object 클래스를 상속하고 있음)
public class User extends Object{
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

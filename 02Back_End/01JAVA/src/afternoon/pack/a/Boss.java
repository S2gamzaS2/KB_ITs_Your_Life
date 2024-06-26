package afternoon.pack.a;

public class Boss {
    String name = "사장이름";
    int age = 100;

    public Boss (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printBoss() {
        System.out.println("[사장이 전달합니다]\n이름: " + this.name + "\n나이: " + this.age);
    }
}

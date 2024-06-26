package afternoon.interfacee.ex;

public class HumanMain {
    public static void main(String[] args) {
        Human[] humans = {new Korean(), new American(), new Spanish()};

        for (Human human : humans) {
            callHuman(human);
        }

    }
    //메소드 안에 메소드 막힘~;
    public static void callHuman(Human human) {
        human.speak();
        human.eat();
        human.hello();
    }
}

package afternoon.lang.object;

public class UserMain {
    public static void main(String[] args) {
        User user1 = new User("감자", "gamza");
        User user2 = new User("감자", "gamza");

        System.out.println(user1 == user2); //false
        System.out.println(user1.equals(user2)); //false //equals-> true
    }
}

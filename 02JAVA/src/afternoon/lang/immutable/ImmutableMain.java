package afternoon.lang.immutable;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableUser user1 = new ImmutableUser("감자");
        ImmutableUser user2 = user1;

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);

        user2 = user2.setName("왕감자");
        System.out.println("user2의 이름을 왕감자로 변경");

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);
    }
}

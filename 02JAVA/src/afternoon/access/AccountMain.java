package afternoon.access;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account(10000 );

        account.deposit(3000); //이자ㅏ~
        account.withdraw(5000); //학식

        System.out.println(account.balance);
    }
}

package afternoon.access;

public class BankAccountMain {
    public static void main(String[] args) {
        BackAccount account = new BackAccount();

        account.deposit(8000);
        account.deposit(700);
        account.getBalance();
        account.deposit(-1200);
        account.withdraw(5000);
        account.withdraw(-200);
        account.getBalance();
    }
}

package afternoon.access.refactor;

public class AccountRefactorMain {
    public static void main(String[] args) {
        AccountRefactor account = new AccountRefactor("국민은행", "골드", "박병창",9000000);
        //bank - public
        //grade - default
        //name - private (접근X)
        //balance = private (접근X)
        System.out.println(account.bank);
    }
}

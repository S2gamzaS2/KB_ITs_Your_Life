package afternoon.access.refactor2;

import afternoon.access.refactor.AccountRefactor;

public class AccountRefactorOuter {
    public static void main(String[] args) {
        AccountRefactor account = new AccountRefactor("하나은행", "다이아", "박병창",800000);

        System.out.println(account.bank);
    }
}

package afternoon.access;

import java.sql.SQLOutput;

public class BackAccount {
    private int balance;

    public BackAccount() {
        this.balance = 0;
    }

    public void deposit(int amount) {
        if (isValidAmount(amount)) {
            this.balance += amount;
            System.out.println("현재 잔고는: " + this.balance);
        } else {
            System.out.println("다시 입력해~~;;");
        }
    }

    public void withdraw(int amount) {
        if (isValidAmount(amount)) {
            if (isPossibleWithdraw(amount)) {
                this.balance -= amount;
                System.out.println("현재 잔고는: " + this.balance);
            } else {
                System.out.println("잔고 부족...~ 힘내~~ 잔고는: " + this.balance);
            }
        } else {
            System.out.println("다시 입력하라고`~:;");
        }
    }

    public void getBalance() {
        System.out.println("현재잔고는,,,~~~~~~~~~~" + this.balance);
    }

    private boolean isValidAmount(int amount) {
        return amount > 0;
    }

    private boolean isPossibleWithdraw(int amount) {
        return this.balance >= amount;
    }

}

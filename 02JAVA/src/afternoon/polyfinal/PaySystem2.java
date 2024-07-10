package afternoon.polyfinal;

import java.util.Scanner;

public class PaySystem2 {
    private Pay pay;
    Scanner sc = new Scanner(System.in);

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void selectPay() {
        System.out.print("결제옵션입력하세욘~ (1.KB 2.Kakao 3.Naver) >> ");
        int option = sc.nextInt();
        this.findPay(option);
    }

    public void findPay(int option) {
        if (option == 1) {
            KBPay kbPay = new KBPay();
            this.setPay(kbPay);
        } else if (option == 2){
            this.setPay(new KakaoPay());
        } else if (option == 3){
            this.setPay(new NaverPay());
        }
    }

    public void selectAmount() {
        System.out.print("결제금액입력하세욘~ >> ");
        int amount =  sc.nextInt();
        this.payment(amount);
    }

    public void payment(int amount) {
        System.out.println("결제를 시작합니다");
        pay.pay(amount);
    }
}

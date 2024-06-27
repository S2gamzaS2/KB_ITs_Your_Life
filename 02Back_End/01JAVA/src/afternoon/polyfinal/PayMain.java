package afternoon.polyfinal;

import java.util.Scanner;

public class PayMain {
    public static void main(String[] args) {
        PaySystem paySystem = new PaySystem();
        Scanner sc = new Scanner(System.in);

        int option;
        int amount;

        System.out.print("결제옵션입력하세욘~ (1.KB 2.Kakao) >> ");
        option = sc.nextInt();

        System.out.print("결제금액입력하세욘~ >> ");
        amount =  sc.nextInt();

        if (option == 1) {
            KBPay kbPay = new KBPay();
            paySystem.setPay(kbPay);
        } else if (option == 2){
            paySystem.setPay(new KakaoPay());
        }
        
        paySystem.payment(amount);
    }
}

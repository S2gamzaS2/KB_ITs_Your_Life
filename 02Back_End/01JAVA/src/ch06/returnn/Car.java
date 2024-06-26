package ch06.returnn;

public class Car {
    int gas;
    String model;
    boolean full;

    //alt+insert -> getter/setter


    public void setGas(int gas) {
        this.gas = gas;
    }


    public boolean isFull() {
        if (gas == 0) {
            System.out.println("가스가 없음");
            return false;
        }
        System.out.println("가스 있음");
        return true;
    }

    public void run() {
        while(true) {
            if (gas > 0) {
                System.out.println("달립니다 가스 잔량: " + gas);
                gas -= 1;
            } else {
                System.out.println("멈춥니다 가스 잔량 : " + gas);
                return; //메소드 종료
            }
        }
    }
}

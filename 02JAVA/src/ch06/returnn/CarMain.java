package ch06.returnn;

public class CarMain {
    public static void main(String[] args) {
        Car mycar = new Car();

        mycar.setGas(5);

        if (mycar.isFull()) {
            System.out.println("출발~");

            mycar.run();
        }
        System.out.println("가스 주입하세요~");
    }
}

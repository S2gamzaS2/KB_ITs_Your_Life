package afternoon.extendss;

public class CarMain {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();

        //new ElectricCar + ctrl + alt + v => 변수명 만들어줌 ㅋ
        ElectricCar electricCar = new ElectricCar();

        gasCar.fillUp();
        gasCar.move();
        gasCar.openDoor();

        electricCar.charge();
        electricCar.move();
        electricCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.openDoor();
        hydrogenCar.fillHydrogen();
    }
}

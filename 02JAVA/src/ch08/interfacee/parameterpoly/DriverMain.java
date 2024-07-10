package ch08.interfacee.parameterpoly;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.drive(new Bus()); //자동 타입 변환 Bus -> Vehicle
        driver.drive(new Taxi()); //자동 타입 변환 Taxi -> Vehicle
    }
}

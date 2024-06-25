package afternoon.classs;

public class FishBreadMain {
    //실행해야되니까 psvm
    public static void main(String[] args) {

        //FishBread 클래스로 만드는 객체라서 데이터타입: FishBread
        //새로운 클래스를 선언 할 때는 new 라는 예약어 사용

        //(1)
//        FishBread fish1 = new FishBread();
//        fish1.taste = "슈크림";
//        fish1.shape = "잉어";
//        fish1.price = 1000;

        //(2)
        FishBread fish1 = new FishBread("마라맛", "상어", 3000);

        fish1.printFishBread();
//        System.out.println("붕어빵의 맛은?: " + fish1.taste);
//        System.out.println("붕어빵의 모양은?: " + fish1.shape);
//        System.out.println("붕어빵의 가격은?: " + fish1.price);
//        System.out.println("붕어빵이 만들어진 시간은?: " + fish1.makeTime);

        //초기값~
        FishBread fish2 = new FishBread();
        fish2.printFishBread();
//        System.out.println("붕어빵의 맛은?: " + fish2.taste);
//        System.out.println("붕어빵의 모양은?: " + fish2.shape);
//        System.out.println("붕어빵의 가격은?: " + fish2.price);
//        System.out.println("붕어빵이 만들어진 시간은?: " + fish2.makeTime);
//
    }


}

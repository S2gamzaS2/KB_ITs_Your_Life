package afternoon.classs;

import java.util.Date;

public class FishBread {
    //class 는 실행 안해도 되니까 psvm 안해도된다~

    //(1)
    String taste = "팥";
    String shape = "붕어";
    int price = 1000;
    Date makeTime = new Date();


    //(2) 생성자
    FishBread(String taste, String shape, int price) {
        this.taste = taste;
        this.shape = shape;
        this.price = price;
    }

    //매개변수 안받는 생성자
    //매개변수 유형 또는 개수가 다른 경우,,~ 초기값 적용,,,~ 오버로딩
    FishBread() {}


    //메서드 - 소문자로~시작하십쇼,,,~ 왜냐면,, 클래스랑 헷갈리니까,,,
    //리턴 없음: void
    void printFishBread() {
        System.out.println("붕어빵의 맛은?: " + this.taste);
        System.out.println("붕어빵의 모양은?: " + this.shape);
        System.out.println("붕어빵의 가격은?: " + this.price);
        System.out.println("붕어빵이 만들어진 시간은?: " + this.makeTime);
    }

}

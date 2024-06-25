package afternoon.classs;

public class Customer {
    String name;
    int age;
    int total;
    boolean isblacklist;

    //여기다가 초기값 넣는게 좋다~ 유집보수가 좋다~ 모름~
    Customer(){
        this.name = "아직 몰라요";
        //원시값은 ,,~~ 안해도됏던것이다,,`~~~~ 원래 저게 초기값이다,,~~~
        this.age = 0;
        this.total = 0;
        this.isblacklist = false;
    }

    Customer(String name, int age, int total, boolean isblacklist) {
        this.name = name;
        this.age = age;
        this.total = total;
        this.isblacklist = isblacklist;
    }

    void printCustomerInfo() {
        System.out.println("고객의 성함은: " + this.name);
        System.out.println("고객의 나이는: " + this.age);
        System.out.println("고객의 총 사용 금액은: " + this.total);
        System.out.println("고객의 블랙리스트 여부는: " + this.isblacklist);
    }
}

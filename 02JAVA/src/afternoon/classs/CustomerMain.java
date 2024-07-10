package afternoon.classs;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer("이효석", 40, 10000, true);
        customer1.printCustomerInfo();
        Customer customer2 = new Customer();
        customer2.printCustomerInfo();

//        customer1.name = "박소해";
//        customer1.age = 29;
//        customer1.total = 1480000;
//        customer1.isblacklist = false;
//
//        System.out.println("고객 이름: " + customer1.name);
//        System.out.println("나이: " + customer1.age);
//        System.out.println("총 사용한 금액: " + customer1.total);
//        System.out.println("blacklist?: " + customer1.isblacklist);
    }
}

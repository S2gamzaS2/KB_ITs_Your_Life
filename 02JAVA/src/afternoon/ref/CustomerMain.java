package afternoon.ref;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.name = "John Doe";

        Customer customer2 = null;

//        customer2 = customer1;
        System.out.println(customer2.name);


    }
}

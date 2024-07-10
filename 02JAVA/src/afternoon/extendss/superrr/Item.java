package afternoon.extendss.superrr;

public abstract class Item {
    //웬만하면 필드는 프라이빗
    private String name;
    private int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("아이템의 이름은 : " + this.name);
        System.out.println("아이템의 가격은 : " + this.price);
    }
}


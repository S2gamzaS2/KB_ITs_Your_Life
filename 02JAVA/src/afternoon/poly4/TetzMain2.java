package afternoon.poly4;

public class TetzMain2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog();
        animals[1] = new Tetz();

        for (int i = 0; i < animals.length; i++) {
            animalDo(animals[i]);

            if (animals[i] instanceof Human) {
                humanDo((Human) animals[i]);
            }
        }
    }

    public static void animalDo(Animal animal) {
        System.out.println("동물 기능 테스툼돠");
        animal.eat();
        animal.sleep();
        System.out.println("동물 기능 테스트 종료함돠");
    }

    public static void humanDo(Human human) {
        System.out.println("사람 기능 테스툼돠");
        human.think();
        System.out.println("사람 기능 테스트 종료함돠");
    }
}

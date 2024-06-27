package afternoon.poly4.ex;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Duck()};

        for (int i = 0; i < animals.length; i++) {
            animalDo(animals[i]);

            if (animals[i] instanceof Fly) {
                flyDo((Fly) animals[i]);
            }
        }
    }

    public static void animalDo(Animal animal) {
        animal.sound();
        animal.eat();
    }

    public static void flyDo(Fly fly) {
        fly.fly();
    }

}

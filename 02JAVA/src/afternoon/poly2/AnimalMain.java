package afternoon.poly2;

public class AnimalMain {
    public static void main(String[] args) {
        Donkey donkey = new Donkey();
        Cat cat = new Cat();
        Chicken chicken = new Chicken();
        Dog dog = new Dog();


        soundAnimal(donkey);
        soundAnimal(cat);
    }

    private static void soundAnimal(Animal animal) {
        animal.sound();
    }

}

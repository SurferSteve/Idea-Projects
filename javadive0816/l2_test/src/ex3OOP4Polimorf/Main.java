package ex3OOP4Polimorf;

/**
 * Created by Steve on 29.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Paulina";
//        cat.about();
//        cat.voice();

        Dog dog = new Dog("Zvezda", 3);
//        dog.about();
//        dog.voice();

        Animal[] animals = new Animal[4];
        animals[0] = cat;
        animals[1] = dog;
        animals[2] = new Lion();
        animals[3] = new Crocodile();

        for (Animal animal : animals) {
//            animal.about();
//            animal.run();
            animal.voice();
        }
    }
}

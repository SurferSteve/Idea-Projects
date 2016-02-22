package ex1;

/**
 * Created by Steve on 22.02.2016.
 */
public class Yard {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 10;
        cat1.name = "Murka";
        cat1.eat();
        Cat cat2 = new Cat();
        cat2.age = 5;
        cat2.name = "Tom";
        cat2.eat();

        Cat cat3 = cat1;
        cat3.age = 1;
        cat1.eat();
        Cat cat4 = new Cat("Plushka");
        cat4.sleep();

        Cat cat5 = new Cat("Cat", 5, true);
        cat5.voice();

        Cat cat6 = new Cat("Пушок", 5, true);
        cat6.voice();
    }
}

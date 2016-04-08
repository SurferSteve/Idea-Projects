package ex3OOP3;

/**
 * Created by Steve on 29.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Paulina", 5);
        cat.about();
        cat.voice();

        Dog dog = new Dog("Zvezda", 3);
        dog.about();
        dog.voice();
    }
}

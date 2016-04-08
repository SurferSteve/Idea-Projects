package ex3OOP4Polimorf;

/**
 * Created by Steve on 29.02.2016.
 */
public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    void voice() {
        System.out.println("gav-gav");
        super.voice();
    }
}

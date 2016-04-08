package ex3OOP2;

/**
 * Created by Steve on 29.02.2016.
 */
public class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    public Dog() {
    }

    void voice() {
        System.out.println("gav-gav");
    }
}

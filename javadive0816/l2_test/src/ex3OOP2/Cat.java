package ex3OOP2;

/**
 * Created by Steve on 29.02.2016.
 */
public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat() {
    }

    void voice() {
        System.out.println("myau-myau");
    }
}

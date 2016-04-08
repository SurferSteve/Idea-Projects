package ex3OOP2;

/**
 * Created by Steve on 29.02.2016.
 */
public class Animal {
    String name;
    int age;
    int weight;

    Animal() {

    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void about() {
        System.out.printf("name %s, age %d\n", name, age);
    }

    void voice() {
        System.out.println("some animal voice");
    }
}

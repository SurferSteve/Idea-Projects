package ex3OOP3;

/**
 * Created by Steve on 29.02.2016.
 */
public class Animal {
    String name;
    int age;
    int weight;

    Animal() {

    }

    void about() {
        System.out.printf("name %s, age %d\n", name, age);
    }

    void voice() {
        System.out.println("some animal voice");
    }
}

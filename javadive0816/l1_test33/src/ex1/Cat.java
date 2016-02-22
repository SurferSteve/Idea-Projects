package ex1;

/**
 * Created by Steve on 22.02.2016.
 */
public class Cat {
    boolean isMale; // thi.isMale
    String name; // this.name
    int weight; // this.weight
    int age; // this.age

//    Cat this; // метафора

    Cat() {
//        System.out.println("Я -- РОБОТ! (Конструктор)");
    }

    Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    void eat() {
        about();
        System.out.println("Кушает...");
    }
    void sleep() {
        about();
        System.out.println("Спит...");
    }
    void voice() {
        about();
        System.out.println("мяу-мяу");
    }
    void about() {
        System.out.print(name + " " + age + ": ");
    }
}

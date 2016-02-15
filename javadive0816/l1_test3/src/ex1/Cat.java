package ex1;

/**
 * Created by Steve on 23.08.2015.
 */
public class Cat {  // Сам класс - шаблон. Экземпляр класса - реальный объект.
    // Характеристики. Поля класса. Переменные.
    boolean isMale; // this.isMale
    String name; // this.name
    double weight; // this.weight
    int age; // this.age

//    Cat this; // метафора

    // Конструктор
    Cat() {
//        System.out.println("Я -- РОБОТ: Конструктор");
    }


    Cat(String name) {
        this.name = name;
    }


    public Cat(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    // Что класс умеет делать, действия, скиллы, навыки. Методы класса.
    void eat () {
        about();
        System.out.println("кушает...");
    }

    void sleep() {
        about();
        System.out.println(("ZZZZZZ...спит..."));
    }

    void voice() {
        about();
        System.out.println("myau-myau");
    }

    void about() {
        System.out.print(name + " " + age + ": ");
    }
}

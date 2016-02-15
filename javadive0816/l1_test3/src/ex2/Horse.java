package ex2;

/**
 * Created by Steve on 23.08.2015.
 */
public class Horse {
    String color;
    String name;
    int speed;
    boolean isMale;
    int age;

    void ride() {
        about();
        System.out.println("riding at speed: " + speed);
    }

    void about () {
        String sex;
        sex = isMale ? "Male" : "Feemale"; // тернарный оператор
        // souf
        System.out.printf("name %s, age %s, sex %s,  : ", name, age, sex);
    }


}

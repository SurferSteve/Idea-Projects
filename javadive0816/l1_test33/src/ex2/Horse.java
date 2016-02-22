package ex2;

/**
 * Created by Steve on 22.02.2016.
 */
public class Horse {
    String color;
    String name;
    int speed;
    boolean isMale;
    int age;
    int rank = 0;

    void ride() {
        about();
        System.out.println("скачет на скорости: " + speed);
    }

    void about() {
        String sex;
        sex = isMale ? "Самец" : "Самка";
        System.out.printf("имя %s, возраст %s, пол %s, ранг %s : ", name, age, sex, rank);

    }
}

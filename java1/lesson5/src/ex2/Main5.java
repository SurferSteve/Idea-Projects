package ex2;

/**
 * Created by Steve on 02.05.2016.
 */
public class Main5 {

    public static void main(String[] args) {

        Flyable object = new Flyable() { // класс без имени - анонимный внутренний класс
            @Override
            public void fly() {

            }

            @Override
            public void land() {

            }
        };

//        NoName noName = new NoName();

    }
}

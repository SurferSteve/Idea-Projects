package ex2;

/**
 * Created by Steve on 02.05.2016.
 */
public class Main4 {

    public static void main(String[] args) {

        class NoName implements Flyable { // вложенный внутренний класс
            @Override
            public void fly() {

            }

            @Override
            public void land() {

            }
        }

        NoName noName = new NoName();

    }
}

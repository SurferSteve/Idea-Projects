package ex2;

/**
 * Created by Steve on 02.05.2016.
 */
public class Main3 {
    class NoName2 implements Flyable { // вложенный внутренний класс
        @Override
        public void fly() {

        }

        @Override
        public void land() {

        }
    }

    static class Main3Builder implements Flyable { // вложенный внутренний класс
        static private int i;

        @Override
        public void fly() {

        }

        @Override
        public void land() {

        }
    }

    public static void main(String[] args) {
        Main3.Main3Builder main3Builder = new Main3Builder();
        Main3Builder.i = 10;

        class NoName implements Flyable { // вложенный внутренний класс
            @Override
            public void fly() {

            }

            @Override
            public void land() {

            }
        }
    }
}

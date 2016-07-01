package ex1;

/**
 * Created by Steve on 20.05.2016.
 */
public class Main2 {
    static class Jamy extends Thread {
        @Override
        public void run() {
            System.out.println(getName());
        }
    }

    public static void main(String[] args) {
        Jamy jamy = new Jamy();
        jamy.start();
    }
}

package ex1;

/**
 * Created by Steve on 10.06.2016.
 * Pattern Observer
 */
public class Main1 {
    public static void main(String[] args) {
        Timer timer = new Timer(3);
        timer.addObserver(new Task("task 1"));
        timer.addObserver(new Task("super task"));
        timer.addObserver(new Task("mail"));
        timer.addObserver(new Observer() {
            @Override
            public void actionPerformed() {
                System.out.println("анонимный внутренний обзёрвер");
            }
        });
        timer.start();
    }
}

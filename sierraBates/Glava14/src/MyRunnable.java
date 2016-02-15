/**
 * Created by Steve on 16.12.2015.
 */
public class MyRunnable implements Runnable {
    public void run() {
        go();
    }
    public void go() {
        doMore();
    }
    public void doMore() {
        System.out.println("Вершина стека");
    }
}

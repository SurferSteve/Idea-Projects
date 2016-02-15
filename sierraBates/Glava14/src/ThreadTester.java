/**
 * Created by Steve on 16.12.2015.
 */
public class ThreadTester {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        System.out.println("Возвращаеся в метод main");
    }
}

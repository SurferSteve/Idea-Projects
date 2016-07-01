package ex2;

import java.io.IOException;

/**
 * Created by Steve on 20.05.2016.
 */
public class Main3 {
    public volatile static boolean flag = true;

    public static class ThreadFlagReader extends Thread {
        public void run() {
            while (flag){}
            System.err.println("ThreadFlagReader completed! " + flag);
        }
    }

    public static class ThreadFlagSetter extends Thread {
        public void run() {
            try {
                int read = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = false;
            System.err.println("Flag set to " + flag);
        }
    }

    public static void main(String[] args) {
        new ThreadFlagReader().start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new ThreadFlagSetter().start();
    }
}

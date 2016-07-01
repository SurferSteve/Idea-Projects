package ex1;

/**
 * Created by Steve on 20.05.2016.
 */
public class Main {
    public static class MyThread extends Thread {
        @Override
        public synchronized void start() {
            makeFun();
            super.start();
        }

        private void makeFun() {
            System.out.println("This is Fun!");
        }

        @Override
        public void run() {
            super.run();
        }
    }

    static class Recipe implements Runnable {
        void cook() {
            System.err.println(Thread.currentThread().getName());
//            System.out.println("...");
        }

        @Override
        public synchronized void run() {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            for (int i = 0; i < 3; i++) {
//                cook();
                System.err.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Recipe());
        Thread thread2 = new Thread(new Recipe());
        thread.start();
        thread2.start();
        new Thread(new Recipe()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Anonymous internal abstract class thread");
            }
        }).start();
        new Thread(() -> {
            {
                System.err.println("lambda thread");
            }
        }).start();
//        thread.setName("Повар");
//        System.err.println(thread.getName());
        System.err.println(Thread.currentThread().getName());
    }
}

package ex3;

/**
 * Created by Steve on 20.05.2016.
 */
public class ATM {
    static int money = 100;

    static synchronized void getMoney(int amount) {
        if (amount <= money) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("ALL OK! New amount: " + money);
        } else {
            System.out.println("Not enough money");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {{
            System.out.print("Mickie: ");
            getMoney(50);
        }}).start();
        new Thread(() -> {{
            System.out.print("Leopold: ");
            getMoney(50);
        }}).start();new Thread(() -> {{
            System.out.print("Bob: ");
            getMoney(50);
        }}).start();
    }
}

package dz.atmexample;

/**
 * Created by Steve on 12.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        IAtm superAtm = new Atm();
        ICard superCard = new MasterCard("Байр", 1000);

        superAtm.insertCard(superCard);
        superAtm.getBalance();
        superAtm.withdraw(900);
        superAtm.insertCard(superCard);
        superAtm.withdraw(200);
        superAtm.getBalance();
    }
}

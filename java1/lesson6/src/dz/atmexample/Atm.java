package dz.atmexample;

/**
 * Created by Steve on 11.05.2016.
 */
public class Atm implements IAtm {
    private ICard currentCard;

    @Override
    public void insertCard(ICard card) {
        currentCard = card;
    }

    @Override
    public void eject() {
        currentCard = null;
        System.out.println("MasterCard is ejected!");
    }

    @Override
    public void withdraw(int amount) {
        if (checkAvailableCard()) return;
        if (currentCard.withdraw(amount)) {
            System.out.println("Cash: " + amount + ", New Balance: " + currentCard.getBalance());
            eject();
        } else {
            System.out.println("Not enough money!");
        }
    }

    private boolean checkAvailableCard() {
        if (currentCard == null) {
            System.out.println("No card inserted!");
            return true;
        }
        return false;
    }

    @Override
    public void getBalance() {
        if (checkAvailableCard()) return;
        System.out.println("Balance: " + currentCard.getBalance());
    }

    @Override
    public void getTransactions() {

    }
}

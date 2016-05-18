package dz.atmexample;

/**
 * Created by Steve on 12.05.2016.
 */
public class MasterCard implements ICard {
    private int uin;
    private int amount;
    private String CardHolderName;

    public MasterCard(String cardHolderName, int amount) {
        CardHolderName = cardHolderName;
        this.amount = amount;
    }

    public MasterCard() {
    }

    @Override
    public int getBalance() {
        return amount;
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount <= this.amount) {
            this.amount -= amount;
            return true;
        } else {
            return false;
        }
    }
}

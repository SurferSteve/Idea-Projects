package dz.atmexample;

/**
 * Created by Steve on 11.05.2016.
 */
public interface IAtm {
    void insertCard(ICard card);

    void eject();

    void withdraw(int amount);

//    void checkPin();

    void getBalance();

    void getTransactions();
}

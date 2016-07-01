package dz5;

import java.util.*;

/**
 * Created by Steve on 24.05.2016.
 */
public class Record extends TransComparator {
    private String description;
    private int balance;
    private static Set<Transaction> transactions = new TreeSet<>();
    private Account account;

    public Record() {
    }

    public Record(String description, int balance, Account account) {
        this.description = description;
        this.balance = balance;
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static Set<Transaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(Set<Transaction> transactions) {
        Record.transactions = transactions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

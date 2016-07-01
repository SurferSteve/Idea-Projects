package finmanager;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Steve on 24.05.2016.
 */
public class Record extends SortComparator {
    private String description;
    private int balance;
    private Date date;
    private Set<Record> records = new TreeSet<>();
    private Account account;
    private Category category;
    private User user;

    public Record() {
    }

    public Record(String description, int balance, Account account) {
        this.description = description;
        this.balance = balance;
        this.account = account;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        this.user = this.account.getOwner();
        return user;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setTransactions(Set<Record> records) {
        this.records = records;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

package dz5;

import java.util.*;

/**
 * Created by Steve on 24.05.2016.
 */
public class User implements Comparable {
//public class User {
    private String name;
    private String login;
    private String password;
    private static Set<Record> records;
    private Set<Account> accounts = new TreeSet<>();
//    private ArrayList<User> users;
    public static int usersCount;
    private boolean isRegistered;
//    private MyDataStore myDataStore;

    public User() {
        usersCount++;
        setName("User #" + usersCount);
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    //    public User(String name, MyDataStore myDataStores) {
//        this.myDataStore = myDataStores;
//        for (User user : users) {
//
//        }
//        if (name )
//        this.name = name;
//        usersCount++;
//    }


    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Set<Record> getRecords() {
        return records;
    }

    public static void setRecords(Set<Record> records) {
        User.records = records;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return (getName().compareTo(user.getName()));
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isReg) {
        isRegistered = isReg;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "User: " + getName();
    }
}

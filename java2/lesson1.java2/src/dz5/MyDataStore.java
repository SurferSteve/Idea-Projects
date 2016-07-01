package dz5;

import java.util.*;
import java.util.jar.Pack200;

/**
 * Created by Steve on 24.05.2016.
 */
public class MyDataStore implements DataStore {
    private String name;
    private Set<User> users = new TreeSet<>();
    private Set<String> userNames = new TreeSet<>();
    private Set<Account> accounts = new TreeSet<>();
    private Set<Record> records = new TreeSet<>();
    private Set<Transaction> transactions = new TreeSet<>();
    private static boolean isUserInBase;
    private static boolean isPasswordCorrect;

    @Override
    public User getUser(String name) {
        User tempUser;
        String tempName;
        for (User user : users) {
            tempUser = user;
            tempName = user.getName();
            if (tempName == name) {
                isUserInBase = true;
                return tempUser;
            } else {
                isUserInBase = false;
                System.out.println("Such User name does not exist in the DataBase.");
            }
        }
        return null;
    }

    public String getUserPassword(User userIn) {
        User tempUser;
        String tempPassword;
        for (User user : users) {
            tempUser = user;
            tempPassword = user.getPassword();
            if (tempPassword == userIn.getPassword()) {
                isPasswordCorrect = true;
                return tempPassword;
            } else {
                isPasswordCorrect = false;
                System.out.println("Such Password is not correct.");
            }
        }
        return null;
    }

    public boolean checkUserPassword(User userIn) {
        User tempUser;
        String tempPassword;
        for (User user : users) {
            tempUser = user;
            tempPassword = user.getPassword();
            if (tempPassword == userIn.getPassword()) {
                isPasswordCorrect = true;
                return true;
            } else {
                isPasswordCorrect = false;
                System.out.println("Such Password is not correct.");
                return false;
            }
        }
        return false;
    }

    public Set<User> getAllUsers() {
        return users;
    }

    @Override
    public Set<String> getUserNames() {
        if (users.size() == 0 || users == null) {
            userNames = new TreeSet<String>();
        } else {
            return userNames;
        }
        return userNames;
    }

    @Override
    public Set<Account> getAccounts(User owner) {
//        Set<Account> tempAccounts = new TreeSet<>();
        if (accounts.size() != 0 || accounts != null) {
            for (Account account : accounts) {
                if (account.owner == owner) {
//                    tempAccounts.add(account);
                    accounts.add(account);
                }
            }
//            return tempAccounts;
            return accounts;
        } else {
            accounts = new TreeSet<Account>();
        }
        return accounts;
    }

    public Set<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Set<Record> getRecords(Account account) {
        Set<Record> tempRecords = new TreeSet<>();
        if (records != null || records.size() != 0) {
            for (Record record : records) {
                if (record.getAccount() == account) {
                    tempRecords.add(record);
                }
            }
            return tempRecords;
        } else {
            records = new TreeSet<>();
        }
        return records;
    }

    public Set<Record> getAllRecords() {
        return records;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public void addAccount(User user, Account account) {
        user.addAccount(account);
        account.setOwner(user);
//        users.add(user); // непонятно нужно ли это
        accounts.add(account);
    }

    @Override
    public void addRecord(Account account, Record record) {
        record.setAccount(account);
        records.add(record);
    }

    @Override
    public User removeUser(String name) {
        User tempUser;
        for (User user : users) {
            if (user.getName() == name) {
                tempUser = user;
                users.remove(user);
                return tempUser;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        for (Account account1 : accounts) {
            if (account1.getOwner() == owner) {
                accounts.remove(account1);
            }
        }
        return null;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        for (Record record1 : records) {
            if (record1.getAccount() == from) {
                records.remove(record1);
            }
        }
        return null;
    }

    public void sortTransactions() {
        TransComparator tc = new TransComparator();
        Collections.sort((List<Transaction>) transactions, tc);
    }

    public Set<Transaction> getTransactions(Account account) {
        sortTransactions();
        Set<Transaction> tmpTransactions = new TreeSet<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccount() == account) {
                tmpTransactions.add(transaction);
            }
        }
        return tmpTransactions;
    }

    public Set<Transaction> getAllTransactions() {
        sortTransactions();
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}

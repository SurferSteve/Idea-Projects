package dz5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Steve on 24.05.2016.
 */
public class Transaction {
    private String description;
    private Account account;
//    private int balance;
    private int balance;
    private Date date;
//    private Date dateOfIn;
//    private Date dateOfOut;
//    private boolean isDateInOutSame;
//    private int amountIn;
//    private int amountOut;
    private ArrayList<Integer> operations = new ArrayList<Integer>();

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

//    public Date getDateOfIn() {
//        return dateOfIn;
//    }

//    public void setDateOfIn(Date dateOfIn) {
//        this.dateOfIn = dateOfIn;
//    }

//    public Date getDateOfOut() {
//        return dateOfOut;
//    }
//
//    public void setDateOfOut(Date dateOfOut) {
//        this.dateOfOut = dateOfOut;
//    }
//
//    public boolean isDateInOutSame() {
//        if (getDateOfIn() == getDateOfOut()) {
//            isDateInOutSame = true;
//        } else {
//            isDateInOutSame = false;
//        }
//        return isDateInOutSame;
//    }
//
//    public int getAmountIn() {
//        return amountIn;
//    }
//
//    public void setAmountIn(int amountIn) {
//        this.amountIn = amountIn;
//    }
//
//    public int getAmountOut() {
//        return amountOut;
//    }
//
//    public void setAmountOut(int amountOut) {
//        this.amountOut = amountOut;
//    }

    public List<Integer> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Integer> operations) {
        this.operations = operations;
    }
}

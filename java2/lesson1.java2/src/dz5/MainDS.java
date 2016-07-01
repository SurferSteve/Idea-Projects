package dz5;

import java.util.TreeSet;

/**
 * Created by Steve on 24.05.2016.
 */
public class MainDS {
    public static void main(String[] args) {
        MyDataStore mds = new MyDataStore();
        User user1 = new User("Sasha");
        User user11 = new User("Sasha", "sasha", "password");
        User user2 = new User("Denis");
        User user3 = new User("Vanya");
        User user10 = new User();

        Registration reg = new Registration(mds);
        reg.register(user10);
        System.out.println("reg.getIsLoggedAnyUser() " + reg.getIsLoggedAnyUser());
        System.out.println("reg.getUserLoggedIn() " + reg.getUserLoggedIn());
        reg.authorise();
        mds.addUser(user10);
        System.out.println("reg.getIsLoggedAnyUser() " + reg.getIsLoggedAnyUser());
        System.out.println("reg.getUserLoggedIn() " + reg.getUserLoggedIn());
        reg.logout();

        mds.addUser(user1);
        mds.addUser(user11);
        mds.addUser(user2);
        mds.addUser(user3);


//        Account account1 = new Account();
//        Account account2 = new Account();
//        Account account3 = new Account();
//        Account account4 = new Account();
//
//        Record record1 = new Record();
//        Record record2 = new Record();
//        Record record3 = new Record();
//        Record record4 = new Record();
//
//        mds.addAccount(user1, account1);
//        mds.addAccount(user1, account2);
//        mds.addAccount(user2, account3);
//        mds.addAccount(user3, account4);
    }
}

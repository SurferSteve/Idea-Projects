package finmanager;


import finmanager.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Steve on 24.05.2016.
 */
public class MainDS {
    public static void main(String[] args) {
        MyDataStore mds = new MyDataStore();
        try {
//            DbHelperFinManager.getInstance();
            mds.setDbHelperFinManager(DbHelperFinManager.getInstance());
            mds.registerNewUser();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        MyDataStore mds = new MyDataStore();
//        mds.setDbHelperFinManager(DbHelperFinManager.getInstance(););
//        User user1 = new User("Sasha1");
//        User user11 = new User("Sasha", "sasha", "password");
//        User user2 = new User("Denis");
//        User user3 = new User("Vanya");
//        User user10 = new User();

//        mds.register(user10);
//        mds.registerNewUser();
        mds.getUser("Serg");
//        System.out.println("mds.getUser(\"Sergey\") " + mds.getUser("Sergey"));
//        System.out.println("getIsLoggedAnyUser() " + mds.getIsLoggedAnyUser());
//        System.out.println("getUserLoggedIn() " + mds.getUserLoggedIn());
//        mds.authorise();
//        System.out.println("getIsLoggedAnyUser() " + mds.getIsLoggedAnyUser());
//        System.out.println("getUserLoggedIn() " + mds.getUserLoggedIn());
//        mds.logout();



//        mds.addUser(user1);
//        mds.addUser(user11);
//        mds.addUser(user2);
//        mds.addUser(user3);
//
//
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

package dz5;

import sun.security.util.Password;

import java.util.Scanner;

/**
 * Created by Steve on 24.05.2016.
 */
public class Registration {
    private MyDataStore currentDataStore;
    private boolean isLoggedAnyUser;
    private User currentUser;
//    private String currentUserPassword;

    public Registration(MyDataStore myDataStore) {
        currentDataStore = myDataStore;
    }

    public void register(User user) {
        User usr = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Регистрация: ");
//        System.out.println("Введите желаемое имя пользователя!");
//        usr.setName(sc.nextLine());
        boolean isTrue;
        do {
            System.out.println("Введите Уникальное Имя, которое также будет Вашим Логином!");
            usr.setName(sc.nextLine());
            usr.setLogin(usr.getName());
            if (currentDataStore.getUserNames().contains(usr.getName())) {
                isTrue = true;
            } else {
                isTrue = false;
            }
        } while (isTrue);
        System.out.println("Имя успешно введено и сохранено.");
        System.out.println("Введите Желаемый Пароль");
        usr.setName(sc.nextLine());
        System.out.println("Пароль успешно введен и сохранен.");
        usr.setIsRegistered(true);
        currentDataStore.addUser(usr);
    }

    public void authorise() {
        currentUser = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Чтобы авторизоваться нужно ввести имя и пароль.");
        System.out.println("Введите имя: ");
        boolean isTrue;
        do {
//            try {
                currentUser.setLogin(sc.nextLine());
//            } catch (Exception e) {
//                System.out.println("Неверное имя. Введите правильное имя.");
//            }
            if (currentDataStore.getUserNames().contains(currentUser.getLogin())) {
                isTrue = true;
            } else {
                isTrue = false;
            }
        } while (isTrue);
        System.out.println("Имя принято.");
        currentUser.setName(currentUser.getLogin());

        System.out.println("Введите пароль.");
        do {
//            try {
                currentUser.setPassword(sc.nextLine());
//            } catch (Exception e) {
//                System.out.println("Неверный пароль. Введите пароль ещё раз.");
//            }
            if (currentDataStore.checkUserPassword(currentUser)) {
                isTrue = true;
            } else {
                isTrue = false;
            }
        } while (isTrue);
        System.out.println("Пароль принят.");
        System.out.println(currentUser.getLogin() + ", вы успешно авторизованы.");
        login();
    }

    public User getUserLoggedIn() {
        return currentUser;
    }

    public boolean getIsLoggedAnyUser() {
        return isLoggedAnyUser;
    }

    private void login() {
        isLoggedAnyUser = true;
    }

    public void logout() {
        currentUser = null;
        isLoggedAnyUser = false;
    }
}

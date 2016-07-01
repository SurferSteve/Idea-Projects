package finmanager;

import java.util.*;

/**
 * Created by Steve on 24.05.2016.
 */
public class MyDataStore implements DataStore {
    private String name = "";
    private Set<User> users = new TreeSet<>();
    private Set<String> userNames = new TreeSet<>();
    private Set<Account> accounts = new TreeSet<>();
    private Set<Record> records = new TreeSet<>();
    private Set<Category> categories = new TreeSet<>();
    private Category defaultCategory = new Category("Default");
    private static boolean isUserInBase = false;
    private static boolean isPasswordCorrect = false;
    private static boolean isLoggedAnyUser = false;
    private static User currentUser = null;
    private DbHelperFinManager dbHelperFinManager;

    public DbHelperFinManager getDbHelperFinManager() {
        return dbHelperFinManager;
    }

    public void setDbHelperFinManager(DbHelperFinManager dbHelperFinManager) {
        this.dbHelperFinManager = dbHelperFinManager;
    }

    public MyDataStore() {
        this.categories.add(getDefaultCategory());
    }

    public MyDataStore(String name) {
        this.categories.add(getDefaultCategory());
        this.name = name;
    }

    public MyDataStore(Set<User> users, Set<Account> accounts, Set<Record> records, Set<Category> categories) {
        this.categories.add(getDefaultCategory());
        for (User user : users) {
            addUser(user);
        }
        for (Account account : accounts) {
            addAccount(account);
        }
        for (Record record : records) {
            addRecord(record);
        }
        for (Category category : categories) {
            addCategory(category);
        }
    }

    public MyDataStore(Set<User> users, Set<Category> categories, Set<Account> accounts) {
        this.categories.add(getDefaultCategory());
        for (User user : users) {
            addUser(user);
        }
        for (Category category : categories) {
            addCategory(category);
        }
        for (Account account : accounts) {
            addAccount(account);
        }
    }

    public MyDataStore(Set<User> users, Set<Account> accounts) {
        this.categories.add(getDefaultCategory());
        for (User user : users) {
            addUser(user);
        }
        for (Account account : accounts) {
            addAccount(account);
        }
    }

    public MyDataStore(Set<Record> records) {
        this.categories.add(getDefaultCategory());
        for (Record record : records) {
            User tmpUsr;
            Account tmpAccount;
            Category tmpCategory;
            tmpUsr = record.getUser();
            tmpAccount = record.getAccount();
            tmpCategory = record.getCategory();
            addUser(tmpUsr);
            addAccount(tmpAccount);
            addCategory(tmpCategory);
            addRecord(record);
        }
    }

    private void setDefaultCategory(Category defaultCategory) {
        this.defaultCategory = defaultCategory;
    }

    public Category getDefaultCategory() {
        return defaultCategory;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        if (category.equals(defaultCategory)) {
            System.out.println("The category is default. It cannot be removed.");
        } else {
            categories.remove(category);
        }
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        MyDataStore.currentUser = currentUser;
    }

    public static boolean isLoggedAnyUser() {
        return isLoggedAnyUser;
    }

    public static boolean isPasswordCorrect() {
        return isPasswordCorrect;
    }

    public static void setIsPasswordCorrect(boolean isPasswordCorrect) {
        MyDataStore.isPasswordCorrect = isPasswordCorrect;
    }

    public static boolean isUserInBase() {
        return isUserInBase;
    }

    public static void setIsUserInBase(boolean isUserInBase) {
        MyDataStore.isUserInBase = isUserInBase;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void setUserNames(Set<String> userNames) {
        this.userNames = userNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                isUserInBase = true;
                return user;
            } else {
                isUserInBase = false;
            }
        }
        if (!isUserInBase) {
            System.out.println("Such User name does not exist in the DataBase.");
        }
        return null;
    }

    public String getUserPassword(User userIn) {
        String tempPassword;
        do {
            for (User user : users) {
                tempPassword = user.getPassword();
                if (tempPassword.equals(userIn.getPassword())) {
                    isPasswordCorrect = true;
                    return tempPassword;
                } else {
                    isPasswordCorrect = false;
                    System.out.println("Such Password is not correct.");
                }
            }
        } while (!isPasswordCorrect);
        return null;
    }

    public boolean checkUserPassword(User userIn) {
        String tempPassword;
            for (User user : users) {
                do {
                    tempPassword = user.getPassword();
                    if (tempPassword.equals(userIn.getPassword())) {
                        isPasswordCorrect = true;
                        return true;
                    } else {
                        isPasswordCorrect = false;
                        System.out.println("Such Password is not correct.");
                        return false;
                    }
                } while (user != userIn);
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
        if (accounts.size() != 0 || accounts != null) {
            for (Account account : accounts) {
                if (account.getOwner().equals(owner)) {
                    accounts.add(account);
                }
            }
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
        if (records != null && records.size() != 0) {
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
        accounts.add(account);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void addRecord(Account account, Record record) {
        record.setAccount(account);
        records.add(record);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public User removeUser(String name) {
        User tempUser;
        for (User user : users) {
            if (user.getName().equals(name)) {
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
            if (account1.getOwner().equals(owner)) {
                accounts.remove(account1);
            }
        }
        return null;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        for (Record record1 : records) {
            if (record1.getAccount().equals(from)) {
                records.remove(record1);
            }
        }
        return null;
    }

    public void sortRecords() {
        SortComparator tc = new SortComparator();
        Collections.sort((List<Record>) records, tc);
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    // Регистрация пользователя + добавление в список пользователей (todo в базу данных)
    public void registerNewUser() {
        User usr = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Регистрация: ");
        boolean isTrue;
        do {
            System.out.println("Введите Уникальное Имя, которое также будет Вашим Логином!");
            boolean userNameIsInputCorrectly = false;
            do {
                try {
                    usr.setName(sc.nextLine());
                    userNameIsInputCorrectly = true;
                } catch (Exception e) {
                    System.out.println("Некорректно введённое имя.");
                    userNameIsInputCorrectly = false;
                }
            } while (!userNameIsInputCorrectly);
            usr.setLogin(usr.getName());
            if (getUserNames().contains(usr.getName())) {
                System.out.println("Такое имя уже используется.");
                isTrue = true;
            } else {
                isTrue = false;
            }
        } while (isTrue);
        System.out.println("Имя успешно введено и сохранено.");
        System.out.println("Введите Желаемый Пароль");
        boolean passwordIsInputCorrectly = false;
        do {
            try {
                usr.setPassword(sc.nextLine());
                passwordIsInputCorrectly = true;
            } catch (Exception e) {
                System.out.println("Некорректно введённый пароль.");
                passwordIsInputCorrectly = false;
            }
        } while (!passwordIsInputCorrectly);
        System.out.println("Пароль успешно введен и сохранен.");
        usr.setIsRegistered(true);
        if (!getAllUsers().contains(usr)) {
            addUser(usr);
            dbHelperFinManager.addRegisteredUserPreparedStatement(usr);
        } else {
            System.out.println("Такой пользователь уже зарегистрирован!");
        }
    }

    // Регистрация конкретного пользователя (принимаего и отдельно созданного)
    public void register(User user) {
        User usr = user;
        Scanner sc = new Scanner(System.in);
        System.out.println("Регистрация: ");
        if (usr.getName() != null) {
            usr.setLogin(usr.getName());
        } else {
            boolean isTrue = true;
            do {
                System.out.println("Введите Уникальное Имя, которое также будет Вашим Логином!");
                boolean userNameIsInputCorrectly = false;
                do {
                    try {
                        usr.setName(sc.nextLine());
                        userNameIsInputCorrectly = true;
                    } catch (Exception e) {
                        System.out.println("Некорректно введённое имя.");
                        userNameIsInputCorrectly = false;
                    }
                } while (!userNameIsInputCorrectly);
                if (getUserNames().contains(usr.getName())) {
                    System.out.println("Такое имя уже используется.");
                    isTrue = true;
                } else {
                    isTrue = false;
                }
                usr.setLogin(usr.getName());
                System.out.println("Имя успешно введено и сохранено.");
            } while (isTrue);
        }
        System.out.println("Имя успешно сохранено.");
        if (usr.getPassword() != null) {
            System.out.println("Пароль успешно сохранен.");
        } else {
            System.out.println("Введите Желаемый Пароль");
            boolean passwordIsInputCorrectly = false;
            do {
                try {
                    usr.setPassword(sc.nextLine());
                    passwordIsInputCorrectly = true;
                } catch (Exception e) {
                    System.out.println("Некорректно введённый пароль.");
                    passwordIsInputCorrectly = false;
                }
            } while (!passwordIsInputCorrectly);
            System.out.println("Пароль успешно введен и сохранен.");
        }

        usr.setIsRegistered(true);
        if (!getAllUsers().contains(usr)) {
            addUser(usr);
            dbHelperFinManager.addRegisteredUserPreparedStatement(usr);
        } else {
            System.out.println("Такой пользователь уже зарегистрирован!");
        }
    }

    public void authorise() {
        currentUser = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Чтобы авторизоваться нужно ввести имя и пароль.");
        System.out.println("Введите имя: ");
        boolean isTrue = false;
        do {
            currentUser.setLogin(sc.nextLine());
            if (getUserNames().contains(currentUser.getLogin())) {
                isTrue = true;
            } else {
                isTrue = false;
                System.out.println("Такое имя отсутствует в базе данных. Введите другое имя.");
            }
        } while (!isTrue);
        System.out.println("Имя принято.");
        currentUser.setName(currentUser.getLogin());

        System.out.println("Введите пароль.");
        do {
            currentUser.setPassword(sc.nextLine());
            if (checkUserPassword(currentUser)) {
                isTrue = true;
            } else {
                isTrue = false;
                System.out.println("Вы ввели неверный пароль. Введите ещё раз.");
            }
        } while (!isTrue);
        System.out.println("Пароль принят.");
        System.out.println(currentUser.getLogin() + ", вы успешно авторизованы.");
        login();
    }

    public User getUserLoggedIn() {
        if (getIsLoggedAnyUser()) {
            return currentUser;
        } else {
            return null;
        }
    }

    public boolean getIsLoggedAnyUser() {
        return isLoggedAnyUser;
    }

    public boolean setIsLoggedAnyUser(boolean trueOrFalse) {
        isLoggedAnyUser = trueOrFalse;
        return trueOrFalse;
    }

    private void login() {
        isLoggedAnyUser = true;
    }

    public void logout() {
        System.out.println(currentUser.getLogin() + ", вы успешно вышли из системы.");
        currentUser = null;
        isLoggedAnyUser = false;
    }
}

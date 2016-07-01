package finmanager;

/**
 * Created by Steve on 24.05.2016.
 */
public class Account implements Comparable {
    private User owner;

    public User getOwner() {
        if (owner == null) {
            return new User();
        }
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int compareTo(Object o) {
        Account account = (Account) o;
        return (getOwner().compareTo(account.getOwner()));
    }
}

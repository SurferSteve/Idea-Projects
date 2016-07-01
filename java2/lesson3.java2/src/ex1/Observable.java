package ex1;

/**
 * Created by Steve on 31.05.2016.
 */
public interface Observable {
    public void notifyObservers();

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);
}

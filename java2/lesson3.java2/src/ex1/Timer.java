package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Steve on 10.06.2016.
 */
public class Timer implements Observable {
    private int delay;
    private List<Observer> observers = new ArrayList<>();

    public Timer(int delay) {
        this.delay = delay;
    }

    public void start() {
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.actionPerformed();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

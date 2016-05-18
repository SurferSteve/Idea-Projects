package ex2;

/**
 * Created by Steve on 02.05.2016.
 */
public interface Flyable { // Кровавый Контракт // навык - IFly / Flyable / CanFly
//    final int MAX_COUNT = 100;
    int MAX_COUNT = 100;

    //    abstract void fly();
    void fly();
    void land();
}

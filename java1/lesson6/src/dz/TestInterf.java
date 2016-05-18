package dz;

/**
 * Created by Steve on 11.05.2016.
 */
public interface TestInterf {
    default void act() {
        System.out.println("вот это да!");
    }
}

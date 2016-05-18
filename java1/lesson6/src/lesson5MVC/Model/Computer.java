package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class Computer implements Shootable {

    @Override
    public Point getShoot() {
        return Point.getRandomPoint();
    }
}

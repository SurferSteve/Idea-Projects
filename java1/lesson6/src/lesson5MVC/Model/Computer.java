package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class Computer implements Shootable {
    public static Point point;

    @Override
    public Point getShoot() {
        Point randomPoint = Point.getRandomPoint();
        point = randomPoint;
        return point;
    }
}

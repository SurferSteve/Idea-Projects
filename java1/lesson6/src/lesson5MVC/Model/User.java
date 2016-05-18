package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class User implements Shootable {
    public static Point point;
    public volatile static boolean isShoot;

    @Override
    public Point getShoot() {
//        return Point.getRandomPoint();
        isShoot = false;
        while(!isShoot); // неидеальный вариант - вечный поток - нужно усыпление - thread.sleep()
        return point;
    }
}

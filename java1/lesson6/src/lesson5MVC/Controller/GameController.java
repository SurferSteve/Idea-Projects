package lesson5MVC.Controller;

import lesson5MVC.Model.Field;
import lesson5MVC.Model.Point;
import lesson5MVC.Model.User;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameController {
    public static void doShoot(Point point, Field.Type type) {
        User.point = point;
        User.isShoot = true;
    }
}

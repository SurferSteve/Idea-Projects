package ex3GUI.Controller;

import ex3GUI.Model.Field;
import ex3GUI.Model.Point;
import ex3GUI.Model.User;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameController {
    public static void doShoot(Point point, Field.Type type) {
        User.point = point;
        User.isShoot = true;
    }
}

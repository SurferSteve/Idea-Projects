package lesson5MVC.Controller;

import lesson5MVC.Model.Computer;
import lesson5MVC.Model.Field;
import lesson5MVC.Model.Point;
import lesson5MVC.Model.User;
import lesson5MVC.View.GameWindow;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameController {
    public static void doShoot(Point point, Field.Type type) {
        User.point = point;
        Computer.point = point;
        User.isShoot = true;
        Field.text = "" + type;
//        changeButtonText(point, type);
    }
//    public static void changeButtonText(Point point, Field.Type type) {
//        GameWindow.buttons[point.getX()][point.getY()].setText("" + type);
//    }
}

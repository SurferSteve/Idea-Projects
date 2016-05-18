package ex3GUI.Model; // сама Игра

import java.util.Random;

/**
 * Created by Steve on 10.05.2016.
 */
public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Point getRandomPoint() {
        return new Point(new Random().nextInt(3), new Random().nextInt(3));
    }
}

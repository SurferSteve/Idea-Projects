package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class MainGame {
    public static Field field;
    public static Computer computer;
    public static User user;
    public static boolean isEnd = false;

    public static void reStart() {
        field = null;
        computer = null;
        user = null;
        start();
    }
    public static void stopGame() {
        isEnd = true;
    }

    public static void start() {
        field = new Field();
        computer = new Computer();
        user = new User();
        field.show();
        while (!field.checkWin(Field.Type.X) && !field.checkWin(Field.Type.O) && !isEnd) {
            Field.text = "X";
            field.doShoot(computer.getShoot(), Field.Type.X);
            field.show();
            //todo isWin (checkWin)
            if (field.checkWin(Field.Type.X)) {
                break;
            }

            Field.text = "O";
            field.doShoot(user.getShoot(), Field.Type.O);
            field.show();
            //todo isWin (checkWin)
            if (field.checkWin(Field.Type.O)) {
                break;
            }
        }
        if (field.checkWin(Field.Type.X)) {
            System.out.println("Победил Х!");
            isEnd = true;
        }
        if (field.checkWin(Field.Type.O)) {
            System.out.println("Победил O!");
            isEnd = true;
        }

//        for (int i = 0; i < 10; i++) {
//            field.doShoot(computer.getShoot(), Field.Type.X);
//            field.show();
//            //todo checkWin
//
//            field.doShoot(user.getShoot(), Field.Type.O);
//            field.show();
//            //todo isWin
//        }
    }
}

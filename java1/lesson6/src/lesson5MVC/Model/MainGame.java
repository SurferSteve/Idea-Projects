package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class MainGame {
    public static Field field = new Field();
    public static Computer computer = new Computer();
    public static User user = new User();

    public static void start() {
        field.show();
        while (!field.checkWin(Field.Type.X) && !field.checkWin(Field.Type.O)) {
            field.doShoot(computer.getShoot(), Field.Type.X);
            field.show();
            //todo checkWin
            field.checkWin(Field.Type.X);

            field.doShoot(user.getShoot(), Field.Type.O);
            field.show();
            //todo isWin
            field.checkWin(Field.Type.O);
        }
        if (field.checkWin(Field.Type.X)) {
            System.out.println("Победил Х!");
        }
        if (field.checkWin(Field.Type.O)) {
            System.out.println("Победил O!");
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

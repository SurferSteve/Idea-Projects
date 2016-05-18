package lesson3.XOGame;

import java.util.Scanner;

/**
 * Created by Steve on 02.04.2016.
 */
public class Game {
    public static String userName;
    public static boolean isNotEnd = true;
    public static int shootX;
    public static int shootX2;
    public static int shootY;
    public static int shootY2;
    public static int shootsTotal;

    public void start() {
        System.out.println("Введите, пожалуйста, Ваше имя: ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.nextLine();
        System.out.println("Приветствую, " + userName + ".");
        System.out.println("Вы играете с компьютером.");
        GameField gameField = new GameField();
        gameField.paintFirstTime();
        do {
            gameField.showField();
            System.out.println(userName + ", " + "сделайте Ваш ход. Введите № Строки: ");
            shootX = scanner.nextInt();
            System.out.println("Введите № Колонки: ");
            shootY = scanner.nextInt();
            gameField.shoot(shootX, shootY);
            System.out.println("Ход компьютера: ");
            gameField.shootOfComp();
            shootsTotal++;
            gameField.isNotEnd();
            if (gameField.isNotEnd()) {
                gameField.shootComp(shootX2, shootY2);
            }
        } while (gameField.isNotEnd());
        gameField.showField();
        System.out.println("Игра Окончена.");
//        if (isWin) {
//            System.out.println("Вы выйграли!");
//        } else {
//            System.out.println("Вы проиграли!");
//        }
        System.out.println("Всего сделано Вамим ходов: " + shootsTotal);
    }
}

import java.util.Scanner;

/**
 * Created by Steve on 22.02.2016.
 */
public class Player {
    //    String name;
    static int shots;

    int getDeckCount() {
        Scanner scanner = new Scanner(System.in);
        int shoot;

        do {
            System.out.println("Введите количество палуб корабля от 1 до " + Field.SIZE + ": ");
            if (scanner.hasNextInt()) {
                do {
                    Ship.decksCount = scanner.nextInt();
                } while (Ship.decksCount > Field.SIZE || Ship.decksCount <= 0);
                break;
            } else {
                System.out.println("Вводить буквы или нецелые числа запрещено. Введите число от 1 до " + Field.SIZE + "!");
                scanner.nextLine();
            }
        } while (true);
        return Ship.decksCount;
    }

    int getShoot() {
        Scanner scanner = new Scanner(System.in);
        int shoot;
        do {
            System.out.println("Введите число в диапазоне от 1 до " + Field.SIZE + ": ");
            if (scanner.hasNextInt()) {
                do {
                    shoot = scanner.nextInt() - 1;
                } while (shoot > Field.SIZE || shoot < 0);
                break;
            } else {
                System.out.println("Вводить буквы или нецелые числа запрещено. Введите число от 1 до " + Field.SIZE + "!");
                scanner.nextLine();
            }
        } while (true);
        System.out.println("Выстрел: " + (shoot+1));
        shots++;
        return shoot;
    }
}

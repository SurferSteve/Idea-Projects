package lesson2.SeaBattle_bad;

import java.util.Scanner;

/**
 * Created by Steve on 03.04.2016.
 */
public class PlayerBad {
    String name;

    int getShoot() {
        Scanner scanner = new Scanner(System.in);
        int shoot;
        do {
            System.out.println("диапазон до " + FieldBad.FIELD_SIZE);
            if (scanner.hasNextInt()) {
                shoot = scanner.nextInt();
                break;
            } else {
                System.out.println("Введите всё же число: ");
                scanner.nextLine();
            }
        } while (true);
        System.out.println("X: " + shoot);
        return shoot;
    }
}

package lesson3;

import java.util.Scanner;

/**
 * Created by Steve on 03.04.2016.
 */
public class Player {
    String name;

    int getShoot() {
        Scanner scanner = new Scanner(System.in);
        int shoot;
        do {
            System.out.println("диапазон до " + Field.FIELD_SIZE);
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

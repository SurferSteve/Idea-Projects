package lesson3;

import java.util.Scanner;

/**
 * Created by Steve on 03.04.2016.
 */
public class PlayerNew {
    String name;

    int getShoot() {
        Scanner scanner1 = new Scanner(System.in);
        int shoot;
        do {
            System.out.println("диапазон до " + FieldNew.FIELD_SIZE);
            if (scanner1.hasNextInt()) {
                shoot = scanner1.nextInt();
                break;
            } else {
                System.out.println("Введите всё же число: ");
                scanner1.nextLine();
            }
        } while (true);
        System.out.println("X: " + shoot);
        return shoot;
    }
}

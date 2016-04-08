package SeaBattle;

import java.util.Scanner;

/**
 * Created by igor on 16.08.15.
 */
public class Player {
    String name;

    int getShoot() {
        Scanner scanner = new Scanner(System.in); // Alt-Enter
        int shoot;
//            String s = scanner.nextLine();
//            shoot = Integer.parseInt(s); // NumberFormatException

        do {
            System.out.println("диапазон до " + Field.SIZE);
            if (scanner.hasNextInt()) {
                // Николай_1:ограничение по координатам не сделали
                shoot = scanner.nextInt();
                break;
            } else {
                System.out.println("введите все же число");
                scanner.nextLine();
            }
        } while (true);
        System.out.println("X: " + shoot);
        return shoot;
    }
}

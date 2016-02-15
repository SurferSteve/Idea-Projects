import java.util.Scanner;

/**
 * Created by Steve on 23.08.2015.
 */
public class Player {
    private static int getShoot(Scanner scanner) {
        int shoot;
//            String s = scanner.nextLine();
//            shoot = Integer.parseInt(s);//NumberForamtException

        do {
            System.out.println("диапазон до " + Field.SIZE);
            if (scanner.hasNextInt()) {
                //Николай_1:ограничение по координатам не сделали
                shoot = scanner.nextInt();
                break;
            } else {
                System.out.printf("введите всё же число");
                scanner.nextLine();
            }
        } while (true);
        System.out.println("X: " + shoot);
        return shoot;
    }
}

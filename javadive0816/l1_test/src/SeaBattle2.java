import java.util.Scanner;

/**
 * Created by Steve on 14.02.2016.
 */
public class SeaBattle2 {
    public static void main(String[] args) {
        // ....X......
        char[] cells = new char[10];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
        int shipPosition = 4;
        cells[shipPosition] = 'X';

        int shots = 0;

        do {
            System.out.println(cells);
            System.out.println();
            System.out.println("Введите число от 0 до 9:");

            Scanner scanner = new Scanner(System.in);
            int shoot;
            String input;
            do {
                if (scanner.hasNextInt() & scanner.nextInt() > 0 & scanner.nextInt() < 10) {
//                    if (scanner.nextInt() > 10 || scanner.nextInt() < 0) {
//                        System.out.println("Введите число от 0 до 9!");
//                        scanner.nextLine();
                    shoot = scanner.nextInt();
                    break;
                    } else {
                        System.out.println("Введите число от 0 до 9!");
                        scanner.nextLine();
                        }
            }
                while (true);
                System.out.println("X: " + shoot);
                shots++;

                switch (cells[shoot]) {
                    case '.':
                        System.out.println("Промах!");
                        cells[shoot] = '*';
                        break;
                    case '*':
                        System.out.println("Уже стреляли!");
                        break;
                    case 'X':
                        System.out.println("Корабль Потоплен!");
                        cells[shoot] = '^';
                        System.out.println(cells);
                        break;
                    default:
                        System.out.println("ERROR");
                }
            } while (cells[shipPosition] == 'X');
        System.out.println("Игра Окончена");
        System.out.println("Всего выполнено выстрелов: " + shots);
    }
}

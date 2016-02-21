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
            do {
                if (scanner.hasNextInt()) {
                    shoot = scanner.nextInt();
                    break;
                } else {
                    if (!scanner.hasNextInt()) {
                        System.out.println("Вводить буквы запрещено. Введите число от 0 до 9!");
                        scanner.nextLine();
                    } else {
                        if (scanner.nextInt() > 0) {
                            shoot = scanner.nextInt();
                            break;
                        }
                    }
                }
            }
            while (true);
            System.out.println("Выстрел: " + shoot);
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

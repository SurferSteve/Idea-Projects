import java.util.Scanner;

/**
 * Created by Steve on 23.08.2015.
 */
public class SeaBattle {
    public static void main(String[] args) {
        char[] cells = new char[10];
        for (char cell : cells) {
            cell = '.'; // поправили копию
        }

        int shipPosition = 4;
        cells[shipPosition] = 'X';

        do {
            Scanner scanner = new Scanner(System.in);
            int shoot = scanner.nextInt();

            switch (cells[shoot]) {
                case '.':
                    System.out.println("промах");
                    cells[shoot] = '*';
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
                case 'X':
                    System.out.println("Корабль потоплен");
                    cells[shoot] = '^';
                    System.out.println(cells);
                    break;
                default:
                    System.out.println("ERROR");
            }


        } while (cells[shipPosition] == 'X');
        System.out.println("game over");
    }


}

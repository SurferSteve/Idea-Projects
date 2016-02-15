import java.util.Scanner;

/**
 * Created by igor on 16.08.15.
 */
public class checkSeaBattle {
    public static void main(String[] args) {
        // ....X......
        char[] cells = new char[10];
//        for (char cell : cells) {
//            cell = '.'; // поправили копию
//        }

        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }

        int shipPosition = 4;

        cells[shipPosition] = 'X';

        do {
            System.out.println(cells);
            System.out.println();


            Scanner scanner = new Scanner(System.in); // Alt-Enter
            int shoot;
//            String s = scanner.nextLine();
//            shoot = Integer.parseInt(s); // NumberFormatException

            do {
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

            switch (cells[shoot]) {
                case '.':
                    System.out.println("Промах");
                    cells[shoot] = '*';
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
                case 'X':
                    System.out.println("Корабль потоплен!");
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


// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
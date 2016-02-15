import java.util.Scanner;

/**
 * Created by Steve on 23.08.2015.
 */
public class SeaBattle {
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


//            Test1 t = new Test1();
//            Test1.goPark();
            Scanner scanner = new Scanner(System.in);
            int shoot;
//            String s = scanner.nextLine();
//            shoot = Integer.parseInt(s);//NumberForamtException

            do {
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

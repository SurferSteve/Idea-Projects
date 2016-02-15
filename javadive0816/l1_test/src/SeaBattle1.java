/**
 * Created by Steve on 19.11.2015.
 */
public class SeaBattle1 {
    public static void main(String[] args) {
        // ....X.......
        char[] cells = new char[10];
//        for (char cell : cells) {
//            cell = '.'; // поправили копию
//        }

        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
        cells[4] = 'X';

        do {
            System.out.println(cells);
            System.out.println();



        } while (true);

//        System.out.println("Game Over");


    }
}

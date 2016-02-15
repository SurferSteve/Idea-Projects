/**
 * Created by Steve on 23.08.2015.
 */
public class Test7ArraysTabloUmnozheniya {
    public static void main(String[] args) {
        char[][] cells;
        cells = new char [9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[j][i] = 2; //[столбец][строка]
            }
        }


        cells[1][0] = 'X';
        cells[2][2] = '0';

        cells[1][1] = '0';

        try {
            cells[3][3] = '0';
        } catch (Exception x) {

        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[j][i] + " ");
            }
            System.out.println();
        }
    }
}



// * * *
// * * *
// * * *


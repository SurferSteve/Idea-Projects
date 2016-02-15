/**
 * Created by Steve on 23.08.2015.
 */
public class Field {
    public static final int SIZE = 10; // final - константа
    char[] cells = new char[SIZE]; // из локальной мы перенесли в поля класса
    Ship ship;

    void init() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
    }

    void initShip() {
        int shipPosition = 4;
        cells[shipPosition] = 'X';
    }

    void showField() {
    System.out.println(cells);
        System.out.println();
    }

    void doShoot
}

/**
 * Created by igor on 16.08.15.
 */
public class Field {
    public static final int SIZE = 10; // final -- константа
    char[] cells = new char[SIZE]; // из локальной мы перенесли в поля класса
    Ship ship;
    int shipPosition;

    void init() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
    }

    void initShip() {
        shipPosition = 4;
//        int shipPosition = 4; // локальную переменную из других методов не видно!
        cells[shipPosition] = 'X';
    }

    void showField() {
        System.out.println(cells);
        System.out.println();
    }

    void doShoot(int shoot) {
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
                break;
            default:
                System.out.println("ERROR");
        }
    }

    boolean isNotGameOver() {
        return cells[shipPosition] == 'X';
    }
}

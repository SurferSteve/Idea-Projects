import java.util.Random;

/**
 * Created by Steve on 22.02.2016.
 */
public class Field {
    public static final int SIZE = 10;
    char[] cells = new char[SIZE];
//    Ship ship;
//    int ship1Position;
//    int ship2Position;
//    int ship3Position;

    void init() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
    }

    void initShip() {
        Random random = new Random();
//        ship1Position = random.nextInt(8);
//        ship2Position = ship1Position + 1;
//        ship3Position = ship2Position + 1;
//        int shipPosition = 4;
//        cells[ship1Position] = 'X';
//        cells[ship2Position] = 'X';
//        cells[ship3Position] = 'X';
        Ship.position = random.nextInt(Field.SIZE - Ship.decksCount + 1);
        for (int i = 0; i < Ship.decksCount; i++) {
            cells[Ship.position + i] = 'X';
        }
    }

    void showField() {
        System.out.println(cells);
    }

    void doShoot(int shoot) {
        switch (cells[shoot]) {
            case '.':
                System.out.println("Промах!");
                cells[shoot] = '*';
                break;
            case '*':
                System.out.println("Уже стреляли!");
                break;
            case 'X':
                if (Ship.decksCount > 1) {
                    System.out.println("Ранил!");
                    Ship.decksCount--;
                } else {
                    System.out.println("Потопил!");
                    Ship.decksCount--;
                }
                cells[shoot] = '^';
                break;
            default:
                System.out.println("ERROR");
        }
    }

    boolean isNotGameOver() {
        return Ship.decksCount > 0;
//        return cells[ship1Position] == 'X' || cells[ship2Position] == 'X' || cells[ship3Position] == 'X';
    }
}

package SeaBattle;

/**
 * Created by igor on 16.08.15.
 */
public class Field {
    public static final int SIZE = 10; // final -- константа
    public static final int SHIPS_AMOUNT = 2;
    char[] cells = new char[SIZE]; // из локальной мы перенесли в поля класса
    Ship[] ships = new Ship[SHIPS_AMOUNT];
//    int shipPosition;

    void init() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.';
        }
    }

//    void initShip() {
//        shipPosition = 4;
////        int shipPosition = 4; // локальную переменную из других методов не видно!
//        cells[shipPosition] = 'X';
//    }

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
//                if ((cells[shoot] == 'X') && ((cells[shoot + 1] == 'X' || (cells[shoot - 1] == 'X')))) {
//                    System.out.println("Ранен!");
//                } else {
//                    System.out.println("Корабль потоплен!");
//                }

//                for (int i = 0; i < ships.length; i++) {
//                int tempStartPosition = ships[i].position;
//                int tempEndPosition = ships[i].position + ships[i].size - 1;
//                for (int j = tempStartPosition; j < tempEndPosition; j++) {
//                    if ((cells[j] == 'X') && ((cells[j+1] == 'X' || (cells[j-1] == 'X')))) {
//                        System.out.println("Ранен! Корабль # " + ships[i].shipNumber + " ранен!");
//                    } else {
//                        System.out.println("Убил! "+ ships[i].size + "-палубный Корабль # " + ships[i].shipNumber + " потоплен!");
//                    }
//                }
//            }
                for (int i = 0; i < ships.length; i++) {
                    if (ships[i].decks.isEmpty()) {
                        System.out.println("Убил! " + ships[i].size + "-палубный Корабль # " + ships[i].shipNumber + " потоплен!");
                    } else {
                        System.out.println("Ранен! Корабль # " + ships[i].shipNumber + " ранен!");
                    }
                }
                cells[shoot] = '^';
                break;
            default:
                System.out.println("ERROR");
        }
    }

    void removeKilledDecks(int shoot) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].decks.contains(shoot)) {
                ships[i].decks.remove(shoot);
            } else {
                boolean miss = true;
            }
        }
    }

    boolean isNotGameOver() {
//        return cells[shipPosition] == 'X';
        for (char cell : cells) {
            if (cell == 'X') {
                return true;
            }
        }
        return false;
    }

    boolean isIntersectTwoShips(Ship ship1, Ship ship2) {
        if (ship2.position + ship2.size > ship1.position + 1) {
            return false;
        }

        if (ship1.position + ship1.size > ship2.position + 1) {
            return false;
        }
        return true;
    }

    public void initShips() {
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
            Ship tempShip = new Ship();
            ships[i] = tempShip;

            // проверка
            boolean isIntersect;
            do {
                isIntersect = false;
                tempShip.initWithRandomValues();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShip, ships[j])) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);

            drawShip(tempShip);
        }
    }

    void drawShip(Ship ship) {
        for (int i = 0; i < ship.size; i++) {
            cells[ship.position + i] = 'X';
        }
    }

    // 0123456789
    // 01         // ship1
    //    345     // ship2
}

package lesson3;

/**
 * Created by Steve on 03.04.2016.
 */
public class Field {
    public static final int FIELD_SIZE = 10;
    public static final int SHIPS_COUNT = 3;
    Ship[] ships = new Ship[SHIPS_COUNT];
    public char[] cells = new char[FIELD_SIZE];
    String playerName;

    // Связка класса PlayerBad и FieldBad
    void addPlayer(Player player) {
        playerName = player.name;
    }

    // Инициализация поля в 1ый раз
    void initField() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '~';
        }
        System.out.println(" --------- ");
        System.out.println("|         |");
    }

    // Показ поля
    void showField() {
        System.out.println(cells);
        System.out.println();
    }

    void initShips() {
        for (int i = 0; i < SHIPS_COUNT; i++) {
            Ship tempShip = new Ship();
            ships[i] = tempShip;
            boolean isIntersect;
            do {
                isIntersect = false;
                tempShip.initRandomShipPosition();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShip, ships[j])) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);
            drawShip(tempShip);
        }
    }

    private void drawShip(Ship ship) {
        for (int i = 0; i < ship.deckCount; i++) {
            cells[ship.deckStartPosition + i] = 'X';

        }
    }

    public boolean isIntersectTwoShips(Ship ship1, Ship ship2) {
        if (ship2.deckStartPosition + ship2.deckCount > ship1.deckStartPosition + 1) {
            return false;
        }
        if (ship1.deckStartPosition + ship1.deckCount > ship2.deckStartPosition + 1) {
            return false;
        }
        return true;
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
                for (int i = 0; i < ships.length; i++) {
                    if (ships[i].decks.isEmpty()) {
                        System.out.println("Убил! " + ships[i].deckCount + "-палубный Корабль # " + ships[i].shipNumber + " потоплен!");
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
        for (char cell : cells) {
            if (cell == 'X') {
                return true;
            }
        }
        return false;
    }

}

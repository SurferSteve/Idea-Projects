package lesson2.SeaBattle_bad;

/**
 * Created by Steve on 03.04.2016.
 */
public class FieldBad {
    public static final int FIELD_SIZE = 10;
    public static final int SHIPS_COUNT = 3;
    ShipBad[] shipBads = new ShipBad[SHIPS_COUNT];
    public char[] cells = new char[FIELD_SIZE];
    String playerName;
    public int shootX;
    public int shootY;

    // Связка класса PlayerBad и FieldBad
    void addPlayer(PlayerBad playerBad) {
        playerName = playerBad.name;
    }

    // Инициализация поля в 1ый раз
    void initField() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '~';
        }
    }

    // Показ поля
    void showField() {
        System.out.println(cells);
        System.out.println();
    }

    void initShips() {
        for (int i = 0; i < SHIPS_COUNT; i++) {
            ShipBad tempShipBad = new ShipBad();
            shipBads[i] = tempShipBad;
            boolean isIntersect;
            do {
                isIntersect = false;
                tempShipBad.initRandomShipPosition();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShipBad, shipBads[j])) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);
            drawShip(tempShipBad);
        }
    }

    private void drawShip(ShipBad shipBad) {
        for (int i = 0; i < shipBad.deckCount; i++) {
            cells[shipBad.deckStartPosition + i] = 'X';

        }
    }

    public boolean isIntersectTwoShips(ShipBad shipBad1, ShipBad shipBad2) {
        if (shipBad2.deckStartPosition + shipBad2.deckCount > shipBad1.deckStartPosition + 1) {
            return false;
        }
        if (shipBad1.deckStartPosition + shipBad1.deckCount > shipBad2.deckStartPosition + 1) {
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
                for (int i = 0; i < shipBads.length; i++) {
                    if (shipBads[i].decks.isEmpty()) {
                        System.out.println("Убил! " + shipBads[i].deckCount + "-палубный Корабль # " + shipBads[i].shipNumber + " потоплен!");
                    } else {
                        System.out.println("Ранен! Корабль # " + shipBads[i].shipNumber + " ранен!");
                    }
                }
                cells[shoot] = '^';
                break;
            default:
                System.out.println("ERROR");
        }
    }

    void removeKilledDecks(int shoot) {
        for (int i = 0; i < shipBads.length; i++) {
            if (shipBads[i].decks.contains(shoot)) {
                shipBads[i].decks.remove(shoot);
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

package lesson3.SeaBattleNew;

/**
 * Created by Steve on 08.04.2016.
 */
public class FieldNew {
    static int woundsNumber = 0;
    static int winsNumber = 0;
    static int shotsNumber = 0;
    // old variables:
    public static final int FIELD_SIZE = 10;
    public static final int SHIPS_COUNT = 2;
    ShipNew[] ships = new ShipNew[SHIPS_COUNT];
    public char[] cells = new char[FIELD_SIZE];
    String playerName;

    void drawNewField() {
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                System.out.print("---------------------------------\n");
                System.out.print("|" + "\uD83D\uDEA2" + "                            " + "\uD83D\uDEA2" + "|\n");
            } else {
                if (i == 5) {
                    System.out.print("|" + "\uD83D\uDEA2" + "                            " + "\uD83D\uDEA2" + "|\n");
                    System.out.print("---------------------------------\n");
                } else {
                    System.out.print("|  " + showStatistics(i) + "|\n");
                }
            }
        }
    }


    String showStatistics(int i) {
        String stat = null;
        switch (i) {
            case 1:
                stat = "      " + "\uD83D\uDEA2" + " СТАТИСТИКА " + "\uD83D\uDEA2" + "        ";
                break;
            case 2:
                stat = showWounds();
                break;
            case 3:
                stat = showWins();
                break;
            case 4:
                stat = showShots();
                break;
        }
        return stat;
    }

    String showWounds() {
        String wounds = null;
        wounds = "\uD83D\uDC63 " + "Всего ранено игроком: " + woundsNumber + " \uD83D\uDC63 ";
        return wounds;
    }

    String showWins() {
        String wins = null;
        wins = "\uD83D\uDCCC " + "Всего убито  игроком: " + winsNumber + " \uD83D\uDCCC ";
        return wins;
    }

    String showShots() {
        String wins = null;
        wins = "\uD83D\uDCA3 " + "Всего было выстрелов: " + winsNumber + " \uD83D\uDCA3 ";
        return wins;
    }

    // old methods:
    void doShoot(int shoot) {
        switch (cells[shoot]) {
            case '.':
                System.out.println("Промах");
                cells[shoot] = '*';
                shotsNumber++;
                break;
            case '*':
                System.out.println("Уже стреляли");
                shotsNumber++;
                break;
            case 'X':
                for (int i = 0; i < ships.length; i++) {
                    if (ships[i].decks.isEmpty()) {
                        System.out.println("Убил! " + ships[i].deckCount + "-палубный Корабль # " + ships[i].shipNumber + " потоплен!");
                        winsNumber++;
                        shotsNumber++;
                        i++;
                    } else {
                        System.out.println("Ранен! Корабль # " + ships[i].shipNumber + " ранен!");
                        woundsNumber++;
                        shotsNumber++;
                        i++;
                    }
                }
                cells[shoot] = '^';
                break;
            default:
                System.out.println("ERROR");
        }
    }

    // Связка класса PlayerBad и FieldBad
    void addPlayer(PlayerNew playerNew) {
        playerName = playerNew.name;
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
        String cells2 = "";
        for (int i = 0; i < cells.length; i++) {
            cells2 = cells2 + i;
        }
        char[] cells3 = cells2.toCharArray();
        System.out.println(cells3);
        System.out.println();
    }

    void initShips() {
        for (int i = 0; i < SHIPS_COUNT; i++) {
            ShipNew tempShipNew = new ShipNew();
            ships[i] = tempShipNew;
            boolean isIntersect;
            do {
                isIntersect = false;
                tempShipNew.initRandomShipPosition();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShipNew, ships[j])) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);
            drawShip(tempShipNew);
        }
    }

    private void drawShip(ShipNew shipNew) {
        for (int i = 0; i < shipNew.deckCount; i++) {
            cells[shipNew.deckStartPosition + i] = 'X';

        }
    }

    public boolean isIntersectTwoShips(ShipNew shipNew1, ShipNew shipNew2) {
        if (shipNew1.deckStartPosition + shipNew1.deckCount < shipNew2.deckStartPosition) {
            return false;
        }
        if (shipNew2.deckStartPosition + shipNew2.deckCount < shipNew1.deckStartPosition) {
            return false;
        }
        return true;
    }

    void removeKilledDecks(int shoot) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].decks.contains(shoot)) {
//                ships[i].decks.remove(shoot); // неправильно, т.к. берёт по индексу из числа shoot, а не само число
                ships[i].decks.remove(ships[i].decks.indexOf(shoot));
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

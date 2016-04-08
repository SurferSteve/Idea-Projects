package SeaBattle_bad;

import java.util.ArrayList;

/**
 * Created by Steve on 03.04.2016.
 */
public class Ship {
    String name;
    static int initShipsNumber = 0;
    int shipNumber;
    ArrayList<Integer> decks;

    public static final int MAX_SHIP_DECK_COUNT = 3;
    int deckCount;
    int deckStartPosition;
//    int deckEndPosition;

    void initRandomShipPosition() {
        deckCount = (int) (Math.random() * MAX_SHIP_DECK_COUNT) + 1; // 1 - 3
        deckStartPosition = (int) (Math.random() * (Field.FIELD_SIZE - deckCount)) + 1; // 1 - 10
//        deckEndPosition = deckStartPosition + deckCount;
        decks = new ArrayList<Integer>();
        for (int i = 0; i < deckCount; i++) {
            decks.add(deckStartPosition + i);
        }
        ArrayList tempDecks = decks;
        shipNumber = initShipsNumber + 1;
        initShipsNumber++;
    }
}

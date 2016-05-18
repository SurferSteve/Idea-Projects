package lesson3.SeaBattleNew;

import java.util.ArrayList;

/**
 * Created by Steve on 03.04.2016.
 */
public class ShipNew {
    String name;
    static int initShipsNumber = 0;
    int shipNumber = 0;
    ArrayList<Integer> decks = new ArrayList<Integer>();

    public static final int MAX_SHIP_DECK_COUNT = 3;
    int deckCount;
    int deckStartPosition;
//    int deckEndPosition;

    void initRandomShipPosition() {
        shipNumber = initShipsNumber + 1;
        initShipsNumber++;

        deckCount = (int) (Math.random() * MAX_SHIP_DECK_COUNT) + 1; // 1 - 3
        deckStartPosition = (int) (Math.random() * (FieldNew.FIELD_SIZE - deckCount)) + 1; // 1 - 10
//        deckEndPosition = deckStartPosition + deckCount;

        for (int i = 0; i < deckCount; i++) {
            decks.add(deckStartPosition + i);
        }

    }
}

package SeaBattle;

import java.util.ArrayList;

/**
 * Created by igor on 16.08.15.
 */
public class Ship {
    public static final int MAX_SHIP_LENGTH = 3;
    int position;
    int size;
    static int initShipsNumber = 0;
    int shipNumber;
    ArrayList<Integer> decks;

    void initWithRandomValues() {
        size = (int) (Math.random() * MAX_SHIP_LENGTH) + 1; // 1 - 3
        position = (int) (Math.random() * (Field.SIZE - size)) + 1; // 1 - 10
        decks = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            decks.add(position + i);
        }
        ArrayList tempDecks = decks;
        shipNumber = initShipsNumber + 1;
        initShipsNumber++;
    }


}

package dz5;

import java.util.Comparator;

/**
 * Created by Steve on 24.05.2016.
 */
public class TransComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Transaction trans1;
        Transaction trans2;
        trans1 = (Transaction) o1;
        trans2 = (Transaction) o2;
        return (trans1.getDate().compareTo(trans2.getDate()));
    }
}

package finmanager;

import java.util.Comparator;

/**
 * Created by Steve on 24.05.2016.
 */
public class SortComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Record rec1;
        Record rec2;
        rec1 = (Record) o1;
        rec2 = (Record) o2;
        return (rec1.getDate().compareTo(rec2.getDate()));
    }
}

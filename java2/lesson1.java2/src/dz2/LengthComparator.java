package dz2;

import java.util.*;

/**
 * Created by Steve on 23.05.2016.
 */
public class LengthComparator<T extends Comparable<T> & Set<T>> implements Comparator<T> {
    // You need to implement LengthComparator implements Comparator
    private T subObject;
    private List<T> objects;

    public T getSubObject() {
        return subObject;
    }

    public void setSubObject(T subObject) {
        this.subObject = subObject;
    }

    public static void test() {
        List<String> s = Arrays.asList("aaa", "b", "cd");
//        List<String> s = Collections.asList{"aaa", "b", "cd"}; // ERROR
        // Should return {b, cd , aaa}
        Collections.sort(s, new LengthComparator());
        System.out.println(s);
    }

    @Override
    public int compare(T o1, T o2) {
        return (o1.compareTo(o2));
    }

    public static void main(String[] args) {
        LengthComparator l = new LengthComparator();
        int i = l.compare("aaa", "b");
        System.out.println("aaa > b: " + i);
        i = l.compare("b", "cd");
        System.out.println("b > cd: " + i);
        test();
    }
}

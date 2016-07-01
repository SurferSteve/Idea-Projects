package dz2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Steve on 23.05.2016.
 */
public class MainDz2 {
    // You need to implement LengthComparator implements Comparator
    public static void test() {
        List<String> s = Arrays.asList("aaa", "b", "cd");
    // Should return {b, cd , aaa}
        Collections.sort(s, new LengthComparator());
    }

    public static void main(String[] args) {
        List<String> s = Arrays.asList("aaa", "b", "cd");
        Collections.sort(s, new LengthComparator());
        System.out.println(s);
    }
}

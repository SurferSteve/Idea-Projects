package ex0ArrayList;

import java.util.ArrayList;

/**
 * Created by Steve on 25.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("java");
        list.add("android");

        System.out.println(list);
        System.out.println(list.get(1));
    }
}

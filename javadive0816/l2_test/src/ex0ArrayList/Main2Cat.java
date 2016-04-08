package ex0ArrayList;

/**
 * Created by Steve on 25.02.2016.
 */
public class Main2Cat {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", 10);
        Cat cat2 = new Cat("Tom", 10);

        System.out.println(cat1 == cat2);

        System.out.println(cat1.equals(cat2));
    }
}

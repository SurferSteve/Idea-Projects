package ex9;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main9<T extends Comparable<T>> implements Minimum<T> {
    T[] objects;

    public Main9(T[] objects) {
        this.objects = objects;
    }

    public Main9() {}

    @Override
    public T min() {
        if (objects == null || objects.length == 0) {
            return null;
        }
        T m = objects[0];
        for (T object : objects) {
            if (object.compareTo(m) < 0) {
                m = object;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        String[] strings = {"kitty", "hello", "coding"};
        Main9<String> main9 = new Main9<>(strings);
        System.out.println(main9.min());

        Integer[] ints = {2, 10, 5, 4};
        Main9<Integer> main91 = new Main9<>(ints);
        System.out.println(main91.min());
    }
}

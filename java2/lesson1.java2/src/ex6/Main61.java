package ex6;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main61 {
    public static void main(String[] args) {
        Gen61<Integer> i1 = new Gen61<>(11);
        Gen61<Integer> i2 = new Gen61<>(22);
        Gen61<Float> f1 = new Gen61<>(33.0f);

        i1.showDelta(i2);
//        i1.showDelta(f1); // error earlier
        i1.showDelta(f1);

    }
}

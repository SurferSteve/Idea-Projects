package ex6;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main6 {
    public static void main(String[] args) {
        Gen6<Integer> i1 = new Gen6<>(11);
        Gen6<Integer> i2 = new Gen6<>(22);
        Gen6<Float> f1 = new Gen6<>(33.0f);

        i1.showDelta(i2);
//        i1.showDelta(f1); // error

    }
}

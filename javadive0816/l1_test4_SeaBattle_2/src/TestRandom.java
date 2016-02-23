import java.util.Random;

/**
 * Created by Steve on 23.02.2016.
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int test1 = random.nextInt(8);
            System.out.println(test1);
        }

    }
}

package lesson3;

/**
 * Created by Steve on 08.04.2016.
 */
public class TestXOGameField {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 2;

        for (int i = 0; i < 3; i++) {
            System.out.print("  " + a + "  |  " + b + "  |  " + c + "    \n");
            a += 3;
            b += 3;
            c += 3;
            if (i == 2) {
                break;
            } else {
                System.out.print("-----+-----+-----\n");
            }
        }
    }
}

/**
 * Created by Steve on 19.11.2015.
 */
public class TestMultiplyTable {
    public static void main(String[] args) {
//        int[] table = new int[10];
//        int x = 1;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
//                int num = table[j];
                int num = i * j;
//                num = x * j;
                System.out.print(i + " * " + j + " = " + num + "\t");
                }
//            x++;
            System.out.println();
        }
    }
}

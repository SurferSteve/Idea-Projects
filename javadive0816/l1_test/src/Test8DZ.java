/**
 * Created by Steve on 23.08.2015.
 */
public class Test8DZ {
    public static void main(String[] args) {
        int[][] numbers;
        numbers = new int[9][9];
        // можно без массива обойтись, но раз задание по ним
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                numbers[i][j] = (i + 1) * (j + 1);
                System.out.print((i+1) + "*" + (j+1) + "=" + numbers[i][j]);
                if (numbers[i][j] < 10) System.out.print("   ");
                else System.out.print("  ");
            }
            System.out.println();

        }
    }
}

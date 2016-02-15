/**
 * Created by Steve on 14.02.2016.
 */
public class Test10 {
    public static void main(String[] args) {
        int a = 10;
        int[] numbers = {23, 24, 11, 324234, 233};
// System.out.println(numbers[1]);
        System.out.printf("length %d\n", numbers.length);
// itar + Tab
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }
// название: for each
// iter + Tab
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
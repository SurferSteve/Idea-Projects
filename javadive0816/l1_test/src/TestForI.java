import java.util.Arrays;

/**
 * Created by Steve on 18.11.2015.
 */
public class TestForI {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 5, 6, 7};
        System.out.println(Arrays.toString(numbers));
        System.out.println("количество учеников " + numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            String a = ":";
            int b = numbers[i];
            if (i == (numbers.length - 1)) {
                System.out.print(b);
            } else {
                System.out.print(b + a);
            }
        }
    }
}

import java.util.Arrays;

/**
 * Created by Steve on 23.08.2015.
 */
public class Test7Arrays {
    public static void main(String[] args) {
        String a1 = "Hello";
        String a2 = "Java";
        String a3 = "Android";

//        Integer[] numbers = {5, 3, 4, 2, 3, 1};
//        System.out.println(Arrays.toString(numbers));


        int[] numbers = {5, 3, 4, 2, 3, 1, 5};
        numbers[0] = 1;
        System.out.println(Arrays.toString(numbers));
        System.out.println("количество учеников " + numbers.length);

        //fori
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.print(number);

        }

        //System.out.print();

        //itar
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.print(number);
        }

        //itar
        for (int k = 0; k < args.length; k++) {
            String arg = args[k];
            System.out.print(arg);
        }

        //iter
        for (int number : numbers) {
            System.out.print(number);


        }
    }
}

/**
 * Created by Steve on 23.08.2015.
 */
public class Test6WhileFor {
    public static void main(String[] args) {
        int width = 20;
        int x = 0; // объявление - позволено только 1 раз
        while (x < width) {
            System.out.println("x: " + x);
//            x = x + 1;
//            x += 1;
//            ++x;
            x++;
        }


        x = 0; // использование сколько раз захочется
        do {
            System.out.println("x: " + x);
//            x = x + 1;
//            x += 1;
//            ++x;
            x++;
        } while (x < width);


        //fori + tab
        for (int i = 0; i < width; i++) {
            System.out.println("i: " + i);
        }

    }
}

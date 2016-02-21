/**
 * Created by Borisov on 29.10.2015.
 */
public class FormatText {
    public static void main(String[] args) {
        double x = 1000000000;
        String s = String.format("%, d", x);
        System.out.println(s);
    }
}

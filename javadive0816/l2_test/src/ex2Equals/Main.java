package ex2Equals;

/**
 * Created by Steve on 25.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        // пул строк
        // "hello" // 123
        // "lo" // 876
        // "hel" // 932
        // "hello" // 888

        String string1 = "hello"; // 123
        String string2 = "hello"; // 123

        String temp = "lo"; // 876
        String string3 = "hel" + temp; // 888

//        System.out.println(string1);
//        System.out.println(string2);
//        System.out.println(string1.equals(string2));
        System.out.println(string1 == string2); // 123 == 123
        System.out.println(string1 == string3); // 123 != 888
        System.out.println(string1.equals(string3)); // hello == hello
    }
}

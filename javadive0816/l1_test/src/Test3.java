/**
 * Created by Steve on 23.08.2015.
 */
public class Test3 {
    public static void main(String[] args) { // psvm
        hello("World", "Tom"); // alt - Enter - create new method quickly
        hello("Sky", "Jerry"); // alt - Enter - create new method quickly

        voice("World");

    }

    private static void voice(String name) {
        System.out.println(name);
    }

    private static void hello(String name, String name2) {
        System.out.println("Hello, " + name);
        System.out.println("Bye-bye, " + name2);
    }
}

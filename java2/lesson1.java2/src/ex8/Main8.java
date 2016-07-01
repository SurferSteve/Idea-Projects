package ex8;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main8 {
    int i;

    public Main8() {}
    // обобщённые методы
    public <T extends Number> Main8(T object) {}

    public static <T, V extends Number> void show(T anything, V number) {
        System.out.println(anything.toString() + number.intValue());
    }


    public static void main(String[] args) {
        show("hello" , 12);
        show(34, 12);
        show(new Object(), 12);
    }
}

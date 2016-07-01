package ex1;

/**
 * Created by Steve on 21.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        NonGen intObject = new NonGen(12);
        NonGen strObject = new NonGen("hello");

        String s = (String) strObject.getObject(); // кастинг - плохой вариант
        int i = (Integer) intObject.getObject();

        intObject = strObject;

        System.out.println(((Integer) intObject.getObject())); // .cast, .var
    }
}

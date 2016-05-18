package tests;

/**
 * Created by Steve on 25.04.2016.
 */
public class Date {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        System.out.printf("%tb %<te %<tY", date);
    }
}

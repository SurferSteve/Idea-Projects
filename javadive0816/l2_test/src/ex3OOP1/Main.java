package ex3OOP1;

/**
 * Created by Steve on 25.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Date date = new Date();
//        date.day = 32;
//        date.day++;
        date.setDay(32);
        date.getDay();
        System.out.println(date.getDay());
    }
}

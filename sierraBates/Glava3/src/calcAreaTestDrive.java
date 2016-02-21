/**
 * Created by Borisov on 06.10.2015.
 */
public class calcAreaTestDrive {
    public static void main(String[] args) {
        int b, c, d;
        short a;
        calcAreaClass obj = new calcAreaClass();
        a = 5;
        b = 6;
        c = obj.calcAreaClassMethod(a, 12);
        long e = obj.calcAreaClassMethod(a, b);
        System.out.println(e);
        }
}

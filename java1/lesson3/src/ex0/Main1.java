package ex0;

/**
 * Created by Steve on 06.04.2016.
 */
public class Main1 {
    public static void main(String[] args) {
        int i = 0;
        while (true){
            if (i == 5) {
                break;
            }
            if (i == 3) {
                continue; // аналог goto
            }
            System.out.println(i);
            i++;
        }
    }
}

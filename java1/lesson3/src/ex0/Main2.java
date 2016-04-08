package ex0;

/**
 * Created by Steve on 06.04.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        int i = 0;
        CycleM: // метка
        while (true) {
            do {
                if (i == 5) {
                    break CycleM; // использование метки для прерывания цикла
                }
                i++;
                System.out.println(i);
            } while (true);
        }
    }
}

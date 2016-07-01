package ex4;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main4 {
    public static void main(String[] args) {
        Gen2<Integer> gen2 = new Gen2<>(12);
//        Gen2<String> genString = new Gen2<>("df"); // error - неразрешённый тип
        gen2.show();
    }
}

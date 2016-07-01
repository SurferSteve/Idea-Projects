package ex0;

/**
 * Created by Steve on 18.05.2016.
 */
public class Main4 {
    public static void main(String[] args) {
//        try {
            System.out.println("calculating: " + doTest());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static int doTest() {
        int i = 3;
        try {
            if (i == 3) {
                throw new Exception();
            }
        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(0);
            return i;
        } finally {
            i = 100;
//            return i;
//            return -1;
        }
            return -1;
//        throw new RuntimeException();
    }
}

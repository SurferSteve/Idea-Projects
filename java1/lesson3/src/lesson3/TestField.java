package lesson3;

/**
 * Created by Steve on 08.04.2016.
 */
public class TestField {
    public static void main(String[] args) {
//        System.out.println(" ━━━━━ ");
//        System.out.println(" ̶̶̶ ̶̶̶ ̶ ̶ ̶ ̶ ̶̶̶̶̶̶̶  ");
//        System.out.println("|       |");
//        System.out.println("|̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅  |" + "˥");
//        System.out.println("|̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅̅ ˥");
//        System.out.println("|       |");
//        System.out.println("|_______|");

//        System.out.println(" ╋      ╋ ");
        for (int i = 0; i < 4; i++) {
            System.out.print("\n     |      |      \n");

            if ( i % 2 == 0) {
                System.out.print("\n━━━╋━━━╋━━━\n");
            }
        }
    }
}

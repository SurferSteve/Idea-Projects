/**
 * Created by Borisov on 03.10.2015.
 */
public class Hobbits {
    String name;

    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        h[0] = new Hobbits();
        h[1] = new Hobbits();
        h[2] = new Hobbits();
        int z = -1;
        while (z < 2) {
            z = z + 1;
            h[z].name = "Бильбо";
            if (z == 1) {
                h[z].name = "Фродо";
            }
            if (z == 2) {
                h[z].name = "Сэм";
            }
            System.out.print(h[z].name + " - ");
            System.out.println("имя хорошего хоббита");
            //z = z + 1;
        }
    }
}

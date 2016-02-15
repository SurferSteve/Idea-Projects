import java.util.Scanner;

/**
 * Created by Steve on 23.08.2015.
 */
public class SeaBattle {
    public static void main(String[] args) {
        // ....X......

//        for (char cell : cells) {
//            cell = '.'; // поправили копию
//        }







        do {



//            Test1 t = new Test1();
//            Test1.goPark();
            Scanner scanner = new Scanner(System.in);
            int shoot = getShoot(scanner);

            switch (cells[shoot]) {
                case '.':
                    System.out.println("промах");
                    cells[shoot] = '*';
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
                case 'X':
                    System.out.println("Корабль потоплен");
                    cells[shoot] = '^';
                    System.out.println(cells);
                    break;
                default:
                    System.out.println("ERROR");
            }


        } while (cells[shipPosition] == 'X');
        System.out.println("game over");
    }


}

package ex2;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Steve on 22.02.2016.
 */
public class Yard {
    public static void main(String[] args) {
        Horse[] horses = new Horse[14];
        Horse winner = new Horse();

        System.out.println("Введите число от 0 до 13:");
        Scanner scanner = new Scanner(System.in);
        int stavka = scanner.nextInt();
        System.out.println("Ваша ставка на лошадь Буцефал № " + stavka);
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.println("");

        Random random = new Random();

        for (int i = 0; i < horses.length; i++) {
            Horse tempHorse = new Horse();
            tempHorse.name = "Буцефал " + i;
            tempHorse.age = 1 + random.nextInt(10);
            tempHorse.speed = 10 + random.nextInt(100);
            tempHorse.isMale = random.nextBoolean();

            horses[i] = tempHorse;
        }
        for (int i = 0; i < horses.length; i++) {
            for (int j = 0; j < horses.length; j++) {
                if (horses[i].speed > horses[j].speed) {
                    horses[i].rank = horses[i].rank + 0;
                } else {
                    horses[i].rank++;
                }
            }
        }

        for (Horse horse : horses) {
            horse.ride();
            if (horse.rank == 1) {
                winner.name = horse.name;
//                System.out.println("Лошадь № " + winner.name);
            } else {
                if (horse.rank != 1 && horse.rank == 2) {
                    winner.name = horse.name;
                }
            }
        }
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.print("**************");
        System.out.println("");

        if (horses[stavka].rank == 1) {
            System.out.println("Ваша ставка "+ stavka + " выйграла! Лошадь " + winner.name + " пришла Первой!");
        } else {
            System.out.println("Ваша ставка "+ stavka + " проиграла! Лошадь " + winner.name + " пришла Первой!");
        }
    }
}

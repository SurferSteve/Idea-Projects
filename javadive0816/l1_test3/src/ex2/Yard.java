package ex2;

import java.util.Random;

/**
 * Created by Steve on 23.08.2015.
 */
public class Yard {
    public static void main(String[] args) {
        Horse[] horses = new Horse[14]; // создали только стойло для лошадей но не самих лошадей


        Random random = new Random();
        Random random2 = new Random();

        for (int i = 0; i < horses.length; i++) {
            Horse tempHorse = new Horse(); // будет умирать и создаваться каждый раз как мы заходим в цикл
            tempHorse.name = "Буцефал " + 1;
            tempHorse.age = 1 + random.nextInt(10); // 1 до 10 включительно
            tempHorse.speed = 10 + random.nextInt(100);
            tempHorse.isMale = random.nextBoolean();


            horses[i] = tempHorse;
        }

        for (Horse horse : horses) {
            horse.ride();
        }
    }
}

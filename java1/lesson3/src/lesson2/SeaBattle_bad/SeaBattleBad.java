package lesson2.SeaBattle_bad;

import java.util.Scanner;

/**
 * Created by Steve on 03.04.2016.
 */
public class SeaBattleBad {
    public static void main(String[] args) {
        PlayerBad playerBad = new PlayerBad();
        FieldBad fieldBad = new FieldBad();
        fieldBad.initField();
        fieldBad.initShips();
        fieldBad.addPlayer(playerBad);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя, игрок: ");
        playerBad.name = scanner.nextLine();
        System.out.println("Приветствует, Вас, " + playerBad.name);
        fieldBad.showField();
        do {
            fieldBad.showField();
            int shoot = playerBad.getShoot();
            fieldBad.removeKilledDecks(shoot);
            fieldBad.doShoot(shoot);
        } while (fieldBad.isNotGameOver());

        fieldBad.showField();

        System.out.println("Игра окончена.");
    }
}

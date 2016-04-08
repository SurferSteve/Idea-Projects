package SeaBattle_bad;

import java.util.Scanner;

/**
 * Created by Steve on 03.04.2016.
 */
public class SeaBattle {
    public static void main(String[] args) {
        Player player = new Player();
        Field field = new Field();
        field.initField();
        field.initShips();
        field.addPlayer(player);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя, игрок: ");
        player.name = scanner.nextLine();
        System.out.println("Приветствует, Вас, " + player.name);
        field.showField();
        do {
            field.showField();
            int shoot = player.getShoot();
            field.removeKilledDecks(shoot);
            field.doShoot(shoot);
        } while (field.isNotGameOver());

        field.showField();

        System.out.println("Игра окончена.");
    }
}

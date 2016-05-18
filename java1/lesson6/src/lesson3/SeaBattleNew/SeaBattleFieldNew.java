package lesson3.SeaBattleNew;

import java.util.Scanner;

/**
 * Created by Steve on 08.04.2016.
 */
public class SeaBattleFieldNew {
    public static void main(String[] args) {
        FieldNew fieldNew = new FieldNew();
        fieldNew.initField();
        fieldNew.initShips();
        fieldNew.showField();
        PlayerNew playerNew = new PlayerNew();
        fieldNew.addPlayer(playerNew);

//        Показ палуб кораблей:
//        for (int i = 0; i < 2; i++) {
//            System.out.println(fieldNew.ships[i].decks);
//        }
//        Проверка на работу removeKilledDecks():
//        System.out.println("проверка индекса 1ой палубы корабля № 1");
//        System.out.println("Введи номер 1ой палубы корабля № 1");
//        Scanner scanner = new Scanner(System.in);
//        int numberOf1stPaluba = scanner.nextInt();
//        System.out.println(fieldNew.ships[0].decks.indexOf(numberOf1stPaluba));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя, игрок: ");
        playerNew.name = scanner.nextLine();
        System.out.println("Приветствует Вас, " + playerNew.name);
        do {
            fieldNew.showField();
            int shoot = playerNew.getShoot();
            fieldNew.removeKilledDecks(shoot);
            fieldNew.doShoot(shoot);
        } while (fieldNew.isNotGameOver());

        fieldNew.showField();
        fieldNew.drawNewField();
        System.out.println("Игра окончена.");
    }
}

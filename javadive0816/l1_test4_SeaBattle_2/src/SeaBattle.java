/**
 * Created by Steve on 23.08.2015.
 */
public class SeaBattle {
    public static void main(String[] args) {
        Field field = new Field();
        Player player = new Player();

        field.init();
        player.getDeckCount();
        field.initShip();

        do {
            field.showField();
            int shoot = player.getShoot();
            field.doShoot(shoot);
        } while (field.isNotGameOver());

        field.showField();

        System.out.println("Корабль Потоплен! Игра Окончена!");
        System.out.println("Всего выстрелов: " + Player.shots);
        System.out.println("Всего уничтоженно палуб: " + Ship.decksCount);
    }
}

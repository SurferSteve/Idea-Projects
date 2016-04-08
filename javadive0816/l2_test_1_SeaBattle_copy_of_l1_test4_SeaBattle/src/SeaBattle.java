/**
 * Created by igor on 16.08.15.
 */
public class SeaBattle {
    public static void main(String[] args) {
        Field field = new Field(); // дали право работать со всеми нестатическими методами
        Player player = new Player();
        Ship ship = new Ship();

        field.init();
        field.initShip();

        do {
            field.showField();
            int shoot = player.getShoot();
            field.doShoot(shoot);
        } while (field.isNotGameOver());

        field.showField();

        System.out.println("game over");

    }


}



// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
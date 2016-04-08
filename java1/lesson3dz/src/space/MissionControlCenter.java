package space;

/**
 * Created by Steve on 07.04.2016.
 */
public class MissionControlCenter {
    SpaceShip currentSpaceShip;

    public void launch() {
        System.out.println("Центр Управления разрешает взлёт.");
        for (int i = 10; i >= 0; i--) {
            System.out.println("Обратный отсчёт пошёл: " + i);
        }
        System.out.println("ПУСК");
    }

    public void setCurrentSpaceShip(SpaceShip currentSpaceShip) {
        this.currentSpaceShip = currentSpaceShip;
    }
}

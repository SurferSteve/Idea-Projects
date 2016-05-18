package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class MissionControlCenter {
    Flyable currentSpaceShip;

    void launch() {
        System.out.println("Центр Управления разрешает взлёт.");
        for (int i = 10; i >= 0; i--) {
            System.out.println("Обратный отсчёт пошёл: " + i);
        }
        System.out.println("ПУСК");
        currentSpaceShip.launch();
    }

    public void setCurrentFlyable(Flyable currentSpaceShip) {
        this.currentSpaceShip = currentSpaceShip;
    }
}

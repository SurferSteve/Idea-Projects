package lesson3dz;

/**
 * Created by Steve on 07.04.2016.
 */
public class MissionControlCenter {
    SpaceShip currentSpaceShip;
    SpacePort spacePort;

    void launch() {
        System.out.println("Центральный пункт даёт добро на запуск!");
        for (int i = 10; i >= 0; i--) {
            System.out.println("Обратный отсчёт: " + i);
        }
        System.out.println("ПУСК");
        currentSpaceShip.launch();
    }

    void setCurrentSpaceShip(SpaceShip spaceShip) {
        currentSpaceShip = spaceShip;
    }
}

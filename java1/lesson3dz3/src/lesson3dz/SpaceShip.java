package lesson3dz;

/**
 * Created by Steve on 07.04.2016.
 */
public class SpaceShip {
    Step[] steps;
    String name;
    Pilot pilot;

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    SpaceShip(String name) {
        this.name = name;
    }

    SpaceShip() {}

    void launch() {
        System.out.println("Ракета запущена с космонавтом " + pilot.name);
    }
}

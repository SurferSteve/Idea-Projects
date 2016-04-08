package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class SpaceShip {
    Step[] steps;
    Pilot pilot;
    String name;

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    void launch() {
        System.out.println("Запустили корабль с пилотом: " + pilot.name);
    }
}

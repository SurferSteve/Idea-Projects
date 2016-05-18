package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class SpaceShip implements Flyable {
    Step[] steps;
    Pilot pilot;
    String name;

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public void launch() {
        System.out.println("Запустили корабль с пилотом: " + pilot.name);
    }
}

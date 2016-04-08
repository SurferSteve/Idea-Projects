package space;

/**
 * Created by Steve on 07.04.2016.
 */
public class SpaceShip {
    String name;
    Step step;
    Pilot pilot;

//    SpaceShip(String name) {
//        this.name = name;
//    }

    void launch() {
        System.out.println("Корабль стартовал с пилотом " + pilot.name);
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
}

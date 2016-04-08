package space;

/**
 * Created by Steve on 07.04.2016.
 */
public class SpacePort {
    String name;
    SpaceShip SpaceShip;
    MissionControlCenter missionControlCenter;

    public void setSpaceShip(SpaceShip ship) {
        SpaceShip = ship;
    }

    public void setMissionControlCenter(MissionControlCenter missionControlCenter) {
        this.missionControlCenter = missionControlCenter;
    }

//    public SpacePort(String name) {
//        this.name = name;
//    }
//
//    public SpacePort() {
//
//    }
}

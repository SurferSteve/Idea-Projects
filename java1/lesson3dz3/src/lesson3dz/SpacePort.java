package lesson3dz;

/**
 * Created by Steve on 07.04.2016.
 */
public class SpacePort {
    String name;
    SpaceShip spaceShip;
    MissionControlCenter missionControlCenter;

    void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }

    void setMissionControlCenter(MissionControlCenter missionControlCenter) {
        this.missionControlCenter = missionControlCenter;
    }

    SpacePort(String name) {
        this.name = name;
    }

    SpacePort() {}
}

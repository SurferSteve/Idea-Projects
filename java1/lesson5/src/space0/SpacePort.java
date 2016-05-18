package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class SpacePort {
    String name;
    Flyable spaceShip;
    MissionControlCenter missionControlCenter;

    public void setSpaceShip(Flyable spaceShip) {
        this.spaceShip = spaceShip;
    }

    public void setMissionControlCenter(MissionControlCenter missionControlCenter) {
        this.missionControlCenter = missionControlCenter;
    }
}

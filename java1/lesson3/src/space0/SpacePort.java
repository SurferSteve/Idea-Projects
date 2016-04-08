package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class SpacePort {
    String name;
    SpaceShip SpaceShip;
    MissionControlCenter missionControlCenter;

    public void setSpaceShip(SpaceShip spaceShip) {
        SpaceShip = spaceShip;
    }

    public void setMissionControlCenter(MissionControlCenter missionControlCenter) {
        this.missionControlCenter = missionControlCenter;
    }
}

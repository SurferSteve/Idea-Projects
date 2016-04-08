package space;

/**
 * Created by Steve on 07.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Pilot pilot = new Pilot("Герман Титов");
        SpaceShip angara = new SpaceShip();
        angara.name = "Ангара";
        angara.setPilot(pilot);
        SpacePort baikonur = new SpacePort();
            baikonur.name = "Байконур";
        baikonur.setSpaceShip(angara);
        baikonur.setMissionControlCenter(new MissionControlCenter());
        baikonur.missionControlCenter.launch();
    }
}

package lesson3dz;

/**
 * Created by Steve on 07.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Pilot pilot = new Pilot("Юрий Гагарин");
        SpaceShip angara = new SpaceShip("Ангара");
        angara.setPilot(pilot);
        SpacePort vostochnyy = new SpacePort("Восточный");
        vostochnyy.setSpaceShip(angara);
        vostochnyy.setMissionControlCenter(new MissionControlCenter());
        vostochnyy.missionControlCenter.setCurrentSpaceShip(angara);
        vostochnyy.missionControlCenter.launch();
    }
}

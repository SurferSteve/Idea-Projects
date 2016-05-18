package space0;

/**
 * Created by Steve on 06.04.2016.
 */
public class Main { // связывание разных классов
    public static void main(String[] args) { // DI - Dependency Injection (ussually Spring or other FrameWork are used for that purpose)
        Pilot pilot = new Pilot("Юрий");
        SpacePort baikonur = new SpacePort();
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.name = "Восток";
        spaceShip.setPilot(pilot);
        baikonur.setSpaceShip(spaceShip);
        baikonur.setMissionControlCenter(new MissionControlCenter());
        baikonur.missionControlCenter.setCurrentFlyable(spaceShip);
        baikonur.missionControlCenter.launch();

        baikonur.missionControlCenter.setCurrentFlyable(new Rocket("Спутник Ломоносов"));
        baikonur.missionControlCenter.launch();

        baikonur.missionControlCenter.setCurrentFlyable(new Flyable() {
            @Override
            public void launch() {
                System.out.println("НЛО");
            }
        });
        baikonur.missionControlCenter.setCurrentFlyable(() -> { System.out.println("НЛО");});
        baikonur.missionControlCenter.launch();
    }
}

package space0;

/**
 * Created by Steve on 02.05.2016.
 */
public class Rocket implements Flyable {
    String sputnik;

    public Rocket(String sputnik) {
        this.sputnik = sputnik;
    }

    @Override
    public void launch() {
        System.out.println("Запустили ракету со спутником: " + this.sputnik);
    }
}

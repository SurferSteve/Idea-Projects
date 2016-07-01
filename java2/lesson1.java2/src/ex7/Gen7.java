package ex7;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen7<T extends Number> {
    private T number;

    public Gen7(T number) {
        this.number = number;
    }

    public void showDelta(Gen7<?> anotherGen7) {
        System.out.println(number.doubleValue() - anotherGen7.number.intValue());
    }
}

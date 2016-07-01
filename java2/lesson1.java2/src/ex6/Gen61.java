package ex6;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen61<T extends Number> {
    private T number;

    public Gen61(T number) {
        this.number = number;
    }

    public void showDelta(Gen61<?> operand) {
        System.out.println(number.doubleValue() - operand.number.doubleValue());
    }
}

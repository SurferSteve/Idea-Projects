package ex6;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen6<T extends Number> {
    private T number;

    public Gen6(T number) {
        this.number = number;
    }

    public void showDelta(Gen6<T> operand) {
        System.out.println(number.doubleValue() - operand.number.doubleValue());
    }
}

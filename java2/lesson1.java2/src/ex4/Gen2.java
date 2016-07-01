package ex4;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen2<T extends Number>  {
    T object1;

    public Gen2(T object1) {
        this.object1 = object1;
    }

    public void show() {
        double d = object1.doubleValue();
    }
}

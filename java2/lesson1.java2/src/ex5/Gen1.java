package ex5;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen1<T extends MyClass & MyInterface> {
    private T object;

    public Gen1(T object) {
        this.object = object;
    }
}

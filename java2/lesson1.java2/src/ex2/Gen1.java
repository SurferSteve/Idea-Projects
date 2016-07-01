package ex2;

/**
 * Created by Steve on 21.05.2016.
 */
public class Gen1<T> { // параметризированный класс
    private T object;

    public Gen1(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}

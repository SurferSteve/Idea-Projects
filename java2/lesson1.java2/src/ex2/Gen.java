package ex2;

/**
 * Created by Steve on 21.05.2016.
 */
public class Gen<MyUnknown> { // параметризированный класс
    private MyUnknown object;

    public Gen(MyUnknown object) {
        this.object = object;
    }

    public MyUnknown getObject() {
        return object;
    }

    public void setObject(MyUnknown object) {
        this.object = object;
    }
}

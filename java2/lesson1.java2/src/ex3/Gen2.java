package ex3;

/**
 * Created by Steve on 21.05.2016.
 */
public class Gen2<K, V> { // параметризированный класс
    private K object1;
    private V object2;

    public Gen2(K object, V object2) {
        this.object1 = object;
        this.object2 = object2;
    }

    public K getObject1() {
        return object1;
    }

    public void setObject1(K object1) {
        this.object1 = object1;
    }

    public V getObject2() {
        return object2;
    }

    public void setObject2(V object2) {
        this.object2 = object2;
    }

    @Override
    public String toString() {
        return "Gen2{" +
                "object1=" + object1.getClass().getName() +
                ", object2=" + object2.getClass().getName() +
                '}';
    }
}

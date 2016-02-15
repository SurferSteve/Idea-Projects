/**
 * Created by Steve on 18.12.2015.
 */
public class Mountain {
    String name;
    int height;

    Mountain(String n, int h) {
        name = n;
        height = h;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
    public String toString() {
        return name + " " + height;
    }
}


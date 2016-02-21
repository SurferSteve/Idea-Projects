/**
 * Created by Borisov on 04.10.2015.
 */
public class GoodDog {
    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int s) {
        size = s;
    }
    void bark() {
        if (size > 60) {
            System.out.println("Гав-гав!");
        } else if (size > 14) {
            System.out.println("Вуф-вуф!");
        } else {
            System.out.println("Тяф тяф!");
        }
    }
}

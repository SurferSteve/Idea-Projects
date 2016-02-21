/**
 * Created by Borisov on 29.10.2015.
 */
public class TestBox {
    Integer i = 0;
    int j;

    public TestBox() {}
    public TestBox(int x) {}
    public TestBox(Integer y) {}
    public TestBox(String z) {}

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();

    }
    public void go() {
        j=i;
        System.out.println(i);
        System.out.println(j);
    }
}

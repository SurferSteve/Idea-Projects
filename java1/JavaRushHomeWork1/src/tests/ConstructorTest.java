package tests;

/**
 * Created by Steve on 02.05.2016.
 */
public class ConstructorTest {
    ConstructorTest() {

    }

    ConstructorTest(String s, String s2, String s3) {
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Конструкторв может быть много.");
        System.out.println("Количество зависит от вариация конструкторов.");
        System.out.println("Каждый новый конструктор переопределяет аргументы внутри скобок конструктора.");
    }
}

package ex2;

/**
 * Created by Steve on 22.05.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        Gen basicString = new Gen("raw string"); // базовый сырой тип - мувитон (без обоббщенного синтаксиса
        String s = (String) basicString.getObject();
        System.out.println(s);

        Gen<Integer> intObject = new Gen<Integer>(12);

        Gen<String> stringGen = new Gen<>("hello");
        String s2 = stringGen.getObject();
        System.out.println(s2);

//        intObject = stringGen; // теперь с дженериками это невозможно, проверка во время компиляции
    }
}

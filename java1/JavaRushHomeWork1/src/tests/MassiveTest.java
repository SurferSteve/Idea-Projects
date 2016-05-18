package tests;

import java.util.Arrays;

/**
 * Created by Steve on 02.05.2016.
 */
public class MassiveTest {
    public static void main(String[] args) {
        System.out.println("Проверяем правда ли, что копия массива будет иметь те же изменения в массиве, что и оригинал.");
        String[] massiv1 = {"мама", "наше", "всё"};
        System.out.println("Массив1: " + Arrays.toString(massiv1));
        String[] massiv2 = massiv1;
        System.out.println();

        System.out.println("Массив1 == Массиву 2? " + massiv2.equals(massiv1));
        System.out.println(massiv1.toString() + " | " + massiv2.toString());
        System.out.printf("%1$s %3$h; %2$s %4$h", "Hascode 1: ", "Hascode 2: ",  massiv1, massiv2);
        System.out.println();
        System.out.println();

        System.out.println("Массив2: " + Arrays.toString(massiv2));
        massiv2[0] = "2";
        System.out.println("Массив2: - изменил 0-индекс на цифру 2:  " + Arrays.toString(massiv2));
        System.out.println("Массив1: - изменил 0-индекс на цифру 2 в массиве 2: " + Arrays.toString(massiv1));

        System.out.println();
        System.out.println("Копирование всех элементов массива в другой: ");
        String[] massiv3 = {"мама", "наше", "всё"};
        System.out.println("Массив3: " + Arrays.toString(massiv3));
        String[] massiv4 = Arrays.copyOf(massiv3, massiv3.length);
        System.out.println();

        System.out.println("Массив3 == Массиву 4? " + massiv3.equals(massiv4));
        System.out.println(massiv3.toString() + " | " + massiv4.toString());
        System.out.printf("%1$s %3$h; %2$s %4$h", "Hascode 3: ", "Hascode 4: ",  massiv3, massiv4);
        System.out.println();
        System.out.println();

        System.out.println("Массив4: " + Arrays.toString(massiv4));
        massiv4[0] = "2";
        System.out.println("Массив4: - изменил 0-индекс на цифру 2:  " + Arrays.toString(massiv4));
        System.out.println("Массив3: - изменил 0-индекс на цифру 2 в массиве 4: " + Arrays.toString(massiv3));
        System.out.println();

        System.out.println(massiv1.hashCode());
        System.out.println(massiv2.hashCode());
        System.out.println(massiv3.hashCode());
        System.out.println(massiv4.hashCode());
    }
}

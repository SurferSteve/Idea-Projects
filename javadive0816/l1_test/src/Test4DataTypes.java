/**
 * Created by Steve on 23.08.2015.
 */
public class Test4DataTypes {
    public static void main(String[] args) {
        String s = "hello";

        char ch = 'F';
        ch = 2340;
        System.out.println(ch);

        byte bt = 127;
        System.out.println(Byte.MAX_VALUE);

        short sh = 32767;
        System.out.println(Short.MAX_VALUE);

        // Примитивные типы (у всех есть блихнецы или обёртки)
        int i = 2000000000; // 4 байта // Обёртка Integer // Все числа по умолчанию Int
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        long l = 20000000000L;
        System.out.println(Long.MAX_VALUE);

        float f = 223.3f; // 4 bytes
        System.out.println(Float.MAX_VALUE);

        double d = 2000.3; // 8 ytes
        System.out.println(Double.MAX_VALUE);

        boolean b = true;

    }
}

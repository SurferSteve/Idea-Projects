import java.util.Arrays;

/**
 * Created by Steve on 23.08.2015.
 */
public class Test7Arrays2 {
    public static void main(String[] args) {
        //в стеке
        //в стекле хранятся переменные, ися которых начинается с мальенкой буквы
        int a;
        a = 10;


        // Куча -- в ней храним всё остальное: массивы и объекты
        // куча для всего того, размер чего сразу неизвестен
        // для размещения в куче нужно запрашивать выеление памяти с помощи команды new
        String[] daysOfWeek; // здесь не хранится сам массив! В daysOfWeek хранится только адрес массива в памяти (ссылка)
        daysOfWeek = new String[7];
        String[] asdf;
        asdf = daysOfWeek;

        daysOfWeek[0] = "Понедельник";
        daysOfWeek[1] = "Вторник";
        daysOfWeek[2] = "Среда";
        daysOfWeek[3] = "Четверг";
        daysOfWeek[4] = "Пятница";
        daysOfWeek[5] = "Суббота";
        daysOfWeek[6] = "Воскресенье";

        asdf[1] = "tuesday"; //обращались к нашему единственному и неповторимому массиву, но через другую переменную.
        // Метафора: как будто испольщовали 2 пульта от телевизора - Серра Бейтс Изучаем Java
        System.out.println(Arrays.toString(daysOfWeek));

    }
}

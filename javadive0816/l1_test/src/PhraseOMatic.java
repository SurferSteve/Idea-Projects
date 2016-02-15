/**
 * Created by Steve on 22.09.2015.
 */
public class PhraseOMatic {
    public static void main(String[] args) {
        // Создаю 3 набора слов для выбора. Набор № 1
        String[] wordListOne = {"Хороший", "Отличный", "Великолепный", "Старательный", "Достойный", "Достойнеший",
                "Прекрасный", "Занимательый", "Хитрейший", "Хитрый", "Умный", "Лазурный", "Счастливый", "Зелёный"};
        String[] wordListTwo = {" и Весёлый", " и Интересный", " и Непредсказуемый", " и Класснный", " и Грозный",
        " и Серьёзный"};
        String[] wordListThree = {" Парень", " Молодец", " Хлопец", " Завсигдатай", " Отшельник", " Гарсон", " Месье",
        " Синьор", " Мистер", "Юноша"};
        // Длина 3 массивов слов
        int oneL = (int) (Math.random() * wordListOne.length);
        int twoL = (int) (Math.random() * wordListTwo.length);
        int threeL = (int) (Math.random() * wordListThree.length);
        String testWords = wordListOne[oneL] + wordListTwo[twoL] + wordListThree[threeL] + ".";
        System.out.println(testWords);
    }
}

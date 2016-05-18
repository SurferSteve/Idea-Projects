package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String slovo1 = "Мама";
        String slovo2 = "Мыла";
        String slovo3 = "Раму";

        String slova1 = slovo1 + slovo2 + slovo3;
        String slova2 = slovo1 + slovo3 + slovo2;
        String slova3 = slovo2 + slovo1 + slovo3;
        String slova4 = slovo2 + slovo3 + slovo1;
        String slova5 = slovo3 + slovo1 + slovo2;
        String slova6 = slovo3 + slovo2 + slovo1;

        System.out.println(slova1);
        System.out.println(slova2);
        System.out.println(slova3);
        System.out.println(slova4);
        System.out.println(slova5);
        System.out.println(slova6);
    }
}
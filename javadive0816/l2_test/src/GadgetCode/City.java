package GadgetCode;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by Steve on 27.02.2016.
 */
public class City {
    String ruName = "Москва";
    String enName = "EnglishCity";

    public void getRuName(String name) {
        ruName = name;
    }

    public void getEnName(String name) {
        enName = name;
    }

    public String setEnName(String name) {
        Transliteration tran = new Transliteration();
        enName = tran.toTranslit(ruName);
        return enName;
    }
}

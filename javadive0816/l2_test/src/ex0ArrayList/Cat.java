package ex0ArrayList;

/**
 * Created by Steve on 25.02.2016.
 */
public class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Cat tempCat;
        tempCat = (Cat) obj;
//        if (age == tempCat.age) {
//            return true;
//        }
//
//        if (name.equals(tempCat.name)) {
//            return true;
//        }

        if (age == tempCat.age && name.equals(tempCat.name)) {
            return true;
        }

        return false;
    }
}
package ex2;

import java.util.Comparator;

/**
 * Created by Steve on 13.05.2016.
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
//        return o1.age - o2.age;
        return o1.name.length() - o2.name.length();
    }
}

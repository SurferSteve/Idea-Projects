package ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 13.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        Person person = new Person();
        person.age = 1000;
        person.name = "Tom";
        persons.add(person);
//        persons.add(1000);
        persons.add(new Person("Jerry", 3));
        persons.add(new Person("Marry", 13));
    }
}

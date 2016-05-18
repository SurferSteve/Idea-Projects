package ex3;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Steve on 13.05.2016.
 */
public class Main {
    public static void main(String[] args) {
//        List<Person> persons = new CopyOnWriteArrayList<Person>(); // persons.remove(person) у iter сработает
        List<Person> persons = new ArrayList<Person>();
        Person tomPerson = new Person();
        tomPerson.age = 30;
        tomPerson.name = "Tom";
        persons.add(tomPerson);
        persons.add(new Person("Mary", 10));
        persons.add(new Person("Adam", 10));
        persons.add(new Person("Ilya", 10));
        persons.add(new Person("Jerry", 20));

        // Сработает у CopyOnWriteArrayList<>
//        for (Person person : persons) { // нельзя
//            if (person == tomPerson) {
//                persons.remove(person); // Exception in thread "main" java.util.ConcurrentModificationException
//            }
//        }

//        for (Person person : new ArrayList<Person>(persons)) {
//            if (person == tomPerson) {
//                persons.remove(person);
//            }
//        }

        // itco
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) { // понятнее было бы persons.getIterator();
            Person person =  iterator.next(); // понятнее было бы назвать - getNextElement()
            if (person == tomPerson) {
//                persons.remove(person); // нельзя
                iterator.remove(); // iterator.next() возвратил элемент и remove его удаляет
            }
        }

        for (Person person : persons) {
            System.out.println(person.name + " " + person.age);
        }

    }
}

package ex2;

import java.util.*;

/**
 * Created by Steve on 13.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        Person person = new Person();
        person.age = 30;
        person.name = "Tom";
        persons.add(person);
        persons.add(new Person("Mary", 10));
        persons.add(new Person("Adam", 10));
        persons.add(new Person("Ilya", 10));
        persons.add(new Person("Jerry", 20));

//        Collections.sort(persons);
//        Collections.sort(persons, new PersonComparator());
        Collections.sort(persons, new Comparator<Person>() { // анонимный внтуренний класс
        @Override
        public int compare(Person o1, Person o2) {
//        return o1.age - o2.age;
            return o1.name.length() - o2.name.length();
        }
        });

        for (Person person1 : persons) {
            System.out.println(person1.name + " " + person1.age);
        }

        System.out.println("-----");

        TreeSet<Person> treeSet = new TreeSet<Person>(persons); // отсортированный
        for (Person person1 : treeSet) {
            System.out.println(person1.name + " " + person1.age);
        }

//        System.out.println("---------");
//        Collections.sort(persons, new PersonComparator());
    }
}

package ex0;

import java.util.*;

/**
 * Created by Steve on 12.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Collection collection;
        List<String> list; // упорядоченный, допускаются дубликаты
        Set set; // неотсортированный, дубликатов нет
        Queue queue;

        Map<Integer, Character> map; // ключ -> значение (key -> value)
//        cells[0] = 'X'; // 0 -> 'X;'

        list = new ArrayList<>(); //+50% длина массива при добавлении элемента выходящего за пределы -> быстрее вызывать элемент
//        list = new LinkedList<>(); // вагоны -> быстрее добавлять

        list.add("asdf");
        list.add("hello");
        list.add("hello");
        list.add("java");

        System.out.println(list);
//        System.out.println(list.get(3));

        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------- SET --------------");
        set = new HashSet<>(); // дубликатов нет
//        set = new TreeSet<>(); // сортируется автоматически

        set.add("asdf");
        System.out.println(set.add("hello"));
        System.out.println(set.add("hello"));
        set.add("hello");
        set.add("java");
        System.out.println(set);

        System.out.println("------- MAP --------------");

        map = new HashMap<>();

        map.put(0, 'X');
        map.put(1, 'O');
        map.put(1, 'Y');
        map.put(2, 'X');

        System.out.println(map);

        System.out.println(map.keySet());
        System.out.println(map.values());
//        System.out.println(map.values().toString());

        Map<String, Person> mapName = new HashMap();
        mapName.put("friend", new Person("Tom", 20));
//        mapName.put("friend", new Person("Tom2", 25)); // не останется, переазпишется
        mapName.put("vip", new Person("Kitty", 35));
//        System.out.println(mapName.get("friend").name);

        for (Person person : mapName.values()) {
            System.out.println(person.name);
        }

        Map<Person, String> tagPerson = new HashMap<Person, String>();
        tagPerson.put(new Person("Tom", 20), "friend");
        tagPerson.put(new Person("Jerry", 22), "friend");
        tagPerson.put(new Person("Marry", 25), "friend");
        tagPerson.put(new Person("Kitty", 35), "vip");

        System.out.println(tagPerson);
        System.out.println(tagPerson.values());
        System.out.println(new HashSet<String>(tagPerson.values()));

        for (Map.Entry<Person, String> personStringEntry : tagPerson.entrySet()) {
            if (personStringEntry.getValue().equals("friend")) {
                System.out.println(personStringEntry.getKey().name);
            }
        }

    }
}

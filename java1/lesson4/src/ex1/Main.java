package ex1;

/**
 * Created by Steve on 23.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.setAge(100);
//        System.out.println(cat.getAge());
        cat1.setIsAlive(true);

        new Cat();
        new Cat();
        new Cat();
        new Cat();
        new Cat();

        System.out.println(Cat.getCount());
    }
}

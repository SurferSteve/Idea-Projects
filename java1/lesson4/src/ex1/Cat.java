package ex1;

/**
 * Created by Steve on 23.04.2016.
 */
public class Cat {
    private int age;
    private int weight;
    private String name;
    private boolean isAlive;
    private boolean gender;
    private static int count;

    Cat() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cat.count = count;
    }

    public boolean setIsAlive(boolean is) {
        return isAlive;
    }

    public boolean getIsGender() {
        return gender;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age <= 100) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void voice() {
        System.out.println("Мяу-мяу");
    }
}

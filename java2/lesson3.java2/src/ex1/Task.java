package ex1;

/**
 * Created by Steve on 10.06.2016.
 */
public class Task implements Observer {
    private String name;

    public Task(String name) {
        this.name = name;
    }


    @Override
    public void actionPerformed() {
        System.out.println("Event handled by task: " + name);
    }
}

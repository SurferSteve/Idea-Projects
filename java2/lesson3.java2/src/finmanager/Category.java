package finmanager;

/**
 * Created by Steve on 27.05.2016.
 */
public class Category implements Comparable {
    private int id;
    private String name;
    private String description;
    private String[] testDescriptionList = {"Здоровье", "Еда", "Одежда"};
    private String[] testDescriptionList2 = {"Health", "Food", "Clothes"};

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //todo создать обёртку для класса, которая бы возвращала именно этот класс в зависимости от разных условий

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

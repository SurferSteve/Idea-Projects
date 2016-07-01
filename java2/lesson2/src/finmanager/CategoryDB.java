package finmanager;

/**
 * Created by Steve on 27.05.2016.
 */
public class CategoryDB {
    private int id;
    private String name;

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
}

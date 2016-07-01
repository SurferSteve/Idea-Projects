package finmanager;

/**
 * Created by Steve on 28.05.2016.
 */
public class Category {
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
}

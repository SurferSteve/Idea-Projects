/**
 * Created by Borisov on 15.10.2015.
 */
import java.util.*;

public class DotCom2 {
    private ArrayList<String> locationCells;
    private String name;
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void setName(String n) {
        name = n;
    }
    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + " : ( ");
            } else {
                result = "Попал";
            } // Конец if
        } // Конец if
        return result;
    } // Конец метода
}
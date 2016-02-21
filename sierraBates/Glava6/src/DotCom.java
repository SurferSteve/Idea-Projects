/**
 * Created by Borisov on 11.10.2015.
 */
import java.util.ArrayList;
public class DotCom {
    private ArrayList<String> locationCells;
    //int numOfHits = 0;
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public String checkYourself(String userInput) {
        //int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        //for (int cell : locationCells) {
        if (index >= 0) {
                locationCells.remove(index);
                if (locationCells.isEmpty()) {
                    result = "Потопил";
                } else {
                    result = "Попал";
                }
        }
        return result;
    }
}
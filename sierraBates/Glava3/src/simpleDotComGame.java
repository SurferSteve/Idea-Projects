/**
 * Created by Borisov on 10.10.2015.
 */
public class simpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelperTest helper = new GameHelperTest();
        simpleDotCom theDotCom = new simpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locationCells = {randomNum, randomNum+1, randomNum+2};
        theDotCom.setLocationCells(locationCells);
        boolean isAlive = true;
        while (isAlive = true) {
            String guess = helper.getUserInput("Введите число!");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }

}

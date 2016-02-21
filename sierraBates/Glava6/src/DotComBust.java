import java.util.ArrayList;

/**
 * Created by Borisov on 15.10.2015.
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom2> dotComsList = new ArrayList<DotCom2>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        DotCom2 one = new DotCom2();
        DotCom2 two = new DotCom2();
        DotCom2 three = new DotCom2();
        one.setName("Pets.com");
        two.setName("eToys.com");
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Ваша цель - потопить три сайта.");
        System.out.println("Pets.com, eToys.com, Go2.com.");
        System.out.println("Попытайтесь потопить их за минимальнео количество ходов.");
        for (DotCom2 dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom2 dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    public void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте Ваш ход!");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    public void finishGame() {
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как Ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг Ваших вложений.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}

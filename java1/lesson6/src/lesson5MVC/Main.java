package lesson5MVC;

import lesson5MVC.Model.MainGame;
import lesson5MVC.View.GameWindow;

/**
 * Created by Steve on 10.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.init();

        MainGame.start();
    }
}

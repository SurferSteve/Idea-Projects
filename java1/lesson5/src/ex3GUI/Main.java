package ex3GUI;

import ex3GUI.Model.MainGame;
import ex3GUI.View.GameWindow;

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

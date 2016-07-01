package lesson5MVC.View;

import lesson5MVC.Controller.GameController;
import lesson5MVC.Model.Field;
import lesson5MVC.Model.MainGame;
import lesson5MVC.Model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameWindow extends JFrame {
    public static final int MAX_CELLS_X = 3;
    public static final int MAX_CELLS_Y = 3;
    JPanel jPanel;
    public static JButton[][] buttons;
    public static JButton currentButton;

    public void init() {
        jPanel = new JPanel();
        buttons = new JButton[MAX_CELLS_X][MAX_CELLS_Y];
        currentButton = new JButton();
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XO GAME");

//        jPanel.setLayout(new FlowLayout());
//        JButton jButton = new JButton("Hello");
//        JButton jButton2 = new JButton("ByeBye");
//        add(jButton, BorderLayout.CENTER);
//        add(jButton2, BorderLayout.NORTH);
//        add(new JButton("South", BorderLayout.SOUTH);
//        add(new JButton("EAST"), BorderLayout.EAST);
//        add(new JButton("WEST"), BorderLayout.WEST);

        jPanel.setLayout(new GridLayout(3, 3));

        JButton restart = new JButton("Restart");
        add(restart, BorderLayout.SOUTH);
        restart.addActionListener((ActionEvent e) -> {
            jPanel = null;
            MainGame.isEnd = true;
            init();
//            buttons = new JButton[MAX_CELLS_X][MAX_CELLS_Y];
            addNewButtons();
//            addButtons();
//            initButtonsText();
            MainGame.reStart();
//            String buttonText = "NOT_SET";
//                    String buttonText = e.getActionCommand();
//                    System.out.printf("Button: %s, x: %d, y: %d \n", buttonText, finalJ, finalI);
//                    buttonText = Field.text;
//                    GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
//            if (Field.text == "X") {
//                buttonText = "X";
//            }
//            if (Field.text == "O") {
//                buttonText = "O";
//            }
//            GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
//            restart.setText(buttonText);
            System.out.printf("Button restart is clicked! Restarting the Game!");
        });

        addButtons();

        add(jPanel);
        setVisible(true);
    }

    private void addNewButtons() {
        buttons = new JButton[MAX_CELLS_X][MAX_CELLS_Y];
//        changeButtonsText();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton jButton = new JButton();
                buttons[i][j] = jButton;
            }
        }
        initButtonsText();
    }

    private void addButtons() {
        buttons = new JButton[MAX_CELLS_X][MAX_CELLS_Y];
//        initButtonsText();
//        changeButtonsText();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton jButton = new JButton();
//                jButton.setText(j % 2 == 0 ? "X" : "O");

                buttons[i][j] = jButton;
                currentButton = jButton;
                jPanel.add(jButton);
                final int finalJ = j;
                final int finalI = i;
                jButton.addActionListener((ActionEvent e) -> {
                    String buttonText = "NOT_SET";
//                    String buttonText = e.getActionCommand();
//                    System.out.printf("Button: %s, x: %d, y: %d \n", buttonText, finalJ, finalI);
//                    buttonText = Field.text;
//                    GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
                    if (Field.text == "X") {
                        buttonText = "X";
                    }
                    if (Field.text == "O") {
                        buttonText = "O";
                    }
                    GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
                    jButton.setText(buttonText);
                    System.out.printf("Button: %s, x: %d, y: %d \n", buttonText, finalJ, finalI);
                });
            }
        }
    }

    public void initButtonsText() {
        for (int i = 0; i < MAX_CELLS_X; i++) {
            for (int j = 0; j < MAX_CELLS_Y; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public void changeButtonsText() {
        for (int i = 0; i < MAX_CELLS_X; i++) {
            for (int j = 0; j < MAX_CELLS_Y; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}

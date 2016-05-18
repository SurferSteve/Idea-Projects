package ex3GUI.View;

import ex3GUI.Controller.GameController;
import ex3GUI.Model.Field;
import ex3GUI.Model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameWindow extends JFrame {
    public static final int MAX_CELLS_X = 3;
    public static final int MAX_CELLS_Y = 3;
    JPanel jPanel = new JPanel();
    JButton[][] buttons = new JButton[MAX_CELLS_X][MAX_CELLS_Y];

    public void init() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XO GAME");

//        jPanel.setLayout(new FlowLayout());
//        JButton jButton = new JButton("Hello");
//        JButton jButton2 = new JButton("ByeBye");
//        add(jButton, BorderLayout.CENTER);
//        add(jButton2, BorderLayout.NORTH);
//        add(new JButton("SOUTH"), BorderLayout.SOUTH);
//        add(new JButton("EAST"), BorderLayout.EAST);
//        add(new JButton("WEST"), BorderLayout.WEST);

        jPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton jButton = new JButton();
//                jButton.setText(j % 2 == 0 ? "X" : "O");

                buttons[i][j] = jButton;
                jPanel.add(jButton);
                final int finalJ = j;
                final int finalI = i;
                jButton.addActionListener((ActionEvent e) -> {
                    String buttonText = e.getActionCommand();
                    System.out.printf("Button: %s, x: %d, y: %d \n", buttonText, finalJ, finalI);
                    GameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
                });
            }
        }

        add(jPanel);
        setVisible(true);
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

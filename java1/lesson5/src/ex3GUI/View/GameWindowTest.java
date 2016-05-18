package ex3GUI.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Steve on 10.05.2016.
 */
public class GameWindowTest extends JFrame {
    public void init() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout()); // всегда по-умолчанию вызывается
        JButton jButton = new JButton("Hello");
        JButton jButton2 = new JButton("ByeBye");
        add(jButton, BorderLayout.CENTER);
        add(jButton2, BorderLayout.NORTH);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);
        add(new JButton("EAST"), BorderLayout.EAST);
        add(new JButton("WEST"), BorderLayout.WEST);
    }

}

package ex4Swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Steve on 02.03.2016.
 */
public class MyWindow extends JFrame {
    JTextArea jTextArea;

    MyWindow() {
        setTitle("Hello Java Window");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton jButton = new JButton("Let's go!");
        add(jButton, BorderLayout.SOUTH);

        jTextArea = new JTextArea();
        add(jTextArea, BorderLayout.CENTER);

        for (int i = 0; i < 10; i++) {
            jTextArea.append("text " + i + "\n");
        }

        setVisible(true);

    }
}

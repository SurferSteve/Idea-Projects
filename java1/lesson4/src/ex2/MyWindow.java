package ex2;

import javax.swing.*;

/**
 * Created by Steve on 23.04.2016.
 */
public class MyWindow extends JFrame {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.setSize(400, 300);
        window.setName("Swing");
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

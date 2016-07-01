package ex3.view;

import javax.swing.*;

/**
 * Created by Steve on 24.06.2016.
 */
public class MainWindow {
    private JList list1;
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTabbedPane tabbedPane3;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

package ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

/**
 * Created by Steve on 10.06.2016.
 */
public class PaintFrame extends JFrame {
    private Color color = Color.black;
    List<Line2D.Float> lines = new ArrayList<>();
    Map<List<Line2D.Float>, Color> listOfLines = new HashMap<>();
    DrawPanel panel;
    private Point lastPoint;

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintOldLines(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            for (Line2D.Float line : lines) {
                g2d.draw(line);
            }
        }
        protected void paintOldLines(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

//            Color colorChoose = listOfLines.get(Color.red);
            Iterator<List<Line2D.Float>> mapLineIterator = listOfLines.keySet().iterator();
//            Iterator<Line2D.Float> linesIterator = mapLineIterator.key
            List<Line2D.Float> list;
//            Iterator<List<Line2D.Float>> mapLineIterator1 = listOfLines.keySet().iterator();
            while (mapLineIterator.hasNext()) {
                list = mapLineIterator.next();
                for (Line2D.Float line : list) {
//                    g2d.setColor(listOfLines.get(Color.red));
                    g2d.setColor(listOfLines.get(list));
                    g2d.draw(line);
                }
            }
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        public static final String RED = "red";
        public static final String GREEN = "green";
        public static final String BLUE = "blue";
        public static final String BLACK = "black";
        JButton buttonRed;
        JButton buttonGreen;
        JButton buttonBlue;
        JButton buttonBlack;
        public ButtonPanel() {
            addGeneratedButton(buttonRed, RED, Color.red);
            addGeneratedButton(buttonGreen, GREEN, Color.green);
            addGeneratedButton(buttonBlue, BLUE, Color.blue);
            addGeneratedButton(buttonBlack, BLACK, Color.black);
        }

        private void addGeneratedButton(JButton button, String name, Color color) {
            button = new JButton(name);
            button.setBackground(color);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            Map<String, Color> colorMap;
//            Моя Попытка поработать с HashMap STARTS:
//            Map<String, Color> colorMap = new HashMap<>();
//            if (colorMap == null || colorMap.size() < 1) {
//                colorMap.put("Red", Color.RED);
//                colorMap.put("Green", Color.GREEN);
//                colorMap.put("Blue", Color.BLUE);
//                colorMap.put("Black", Color.BLACK);
//            }
//            Моя Попытка поработать с HashMap ENDS;
            switch (e.getActionCommand()) {
                case RED:
                    listOfLines.put(lines, color);
                    lines = new ArrayList<>();
                    color = Color.red;
                    break;
                case GREEN:
                    listOfLines.put(lines, color);
                    lines = new ArrayList<>();
                    color = Color.green;
                    break;
                case BLUE:
                    listOfLines.put(lines, color);
                    lines = new ArrayList<>();
                    color = Color.blue;
                    break;
                case BLACK:
                    listOfLines.put(lines, color);
                    lines = new ArrayList<>();
                    color = Color.black;
                    break;
                default:
                    listOfLines.put(lines, color);
                    lines = new ArrayList<>();
                    color = Color.black;
                    break;
            }
        }
    }

    public class DrawListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            lastPoint = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point point = e.getPoint();
            if (lastPoint == null) {
                lastPoint = point;
                return;
            }
            lines.add(new Line2D.Float(lastPoint, point));
            lastPoint = point;
            panel.repaint();
        }
    }

    public PaintFrame() { // throws HeadlessException {
        super("Super Color Paint");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        panel = new DrawPanel();
        DrawListener drawListener = new DrawListener();
        panel.addMouseListener(drawListener);
        panel.addMouseMotionListener(drawListener);
        add(panel);
        add(new ButtonPanel(), BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new PaintFrame();
                jFrame.setVisible(true);
            }
        });
//        SwingUtilities.invokeLater(() -> {
//            {
//                JFrame jFrame = new PaintFrame();
//                jFrame.setVisible(true);
//            }
//        });
    }
}

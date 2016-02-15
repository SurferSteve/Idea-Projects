import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Steve on 16.12.2015.
 */
public class BeatBoxFinal {
    JFrame theFrame;
    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
//    JTextField bpm;
//    float bpmText;
    ArrayList<JCheckBox> checkboxList;
    int nextNum;
    Vector<String> listVector = new Vector<String>();
    String userName;
    ObjectOutputStream out;
    ObjectInputStream in;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();

    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;
    Track track;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
            "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell",
            "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};

    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        try {
            new BeatBoxFinal().startUp(args[0]); // это ваш пользовательский идентификатор (отображаемое имя)
        } catch (Exception ex) {
            new BeatBoxFinal().startUp("User"); // это ваш пользовательский идентификатор (отображаемое имя)
        }
    }

    public void startUp(String name) {
        userName = name;
        // Открываем соединение с сервером
        try {
            Socket sock = new Socket("192.168.0.15", 4242);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();
        } catch(Exception ex) {
            System.out.println("couldn't connect - you'll have to play alone.");
        }
        setUpMidi();
        buildGUI();
    } // Закрывам startUp

    public void buildGUI() {
        theFrame = new JFrame("Cyber Beatbox");
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

//        JButton tempoChange = new JButton("Change Tempo");
//        tempoChange.addActionListener(new MyUpdateTempoListener());
//        buttonBox.add(tempoChange);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton empty = new JButton("Empty");
        empty.addActionListener(new MyEmptyListener());
        buttonBox.add(empty);

        JButton open = new JButton("Open");
        open.addActionListener(new MyReadInListener());
        buttonBox.add(open);

        JButton sendIt = new JButton("Send it");
        sendIt.addActionListener(new MySendListener());
        buttonBox.add(sendIt);

        userMessage = new JTextField();
        buttonBox.add(userMessage);

//        bpm = new JTextField();
//        bpmText = sequencer.getTempoFactor();
////        bpm.setText(Float.toString(sequencer.getTempoInBPM()));
////        Box buttonBox1 = new Box(BoxLayout.Y_AXIS);
//        bpm.setText(Float.toString(sequencer.getTempoFactor()));
//        bpm.addActionListener(new MyUpdateTempoListener());
//        bpm.addKeyListener(new MyUpdateTempoKeyListener());
//        buttonBox.add(bpm);

        /**
         * JList - этот компонент, который мы раньше не использовали.
         * В нём отображаются входящие сообщения, которые можно выбирать из списка,
         * а не только просматривать.
         * Благодаря этому вы вправе загружать и воспроизводить прикрепляемые к ним
         * музыкальные шаблоны.
         */

        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);
        incomingList.setListData(listVector); // нет начальных данных

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        } // Конец цикла

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    } // Закрываем buildGUI

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch(Exception e) {
            e.printStackTrace();
        }
    } // Закрываем setUpMidi

    /**
     * Создаём трек проверяя состояние всех флажков и связывая их с инструментом(для которого создается MidiEvent).
     */

    public void buildTrackAndStart() {
        ArrayList<Integer> trackList = null; // Здесь будут храниться инструменты для каждого трека
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new ArrayList<Integer>();

            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
                if (jc.isSelected()) {
                    int key = instruments[i];
                    trackList.add(new Integer(key));
                } else {
                    trackList.add(null); // Этот слот в треке должен быть пустым
                }
            } // Закрываем вложенный цикл
            makeTracks(trackList);
        } // Закрываем внешний цикл

        track.add(makeEvent(192,9,1,0,15)); // В результате мы всегда имеем полные 16 тактов
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Закрываем метод

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
//            bpm.setText(Float.toString(sequencer.getTempoInBPM()));
//            bpm.setText(Float.toString(sequencer.getTempoFactor()));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
//            bpm.setText(Float.toString(sequencer.getTempoInBPM()));
//            bpm.setText(Float.toString(sequencer.getTempoFactor()));
        }
    }

    public class MyReadInListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            boolean[] checkboxState = null;
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("serialized Files", "ser");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(mainPanel);
            try {
                FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream is = new ObjectInputStream(fileIn);
                checkboxState = (boolean[]) is.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (checkboxState[i]) {
                    check.setSelected(true);
                } else {
                    check.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();
        }
    } // конец внутреннего класса

//    public class MyUpdateTempoListener implements ActionListener {
//        public void actionPerformed (ActionEvent ev) {
////            float tempoFactor = sequencer.getTempoFactor();
////            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
//            System.out.println(bpmText);
//            sequencer.setTempoFactor(bpmText);
////            float bpmText = sequencer.getTempoInBPM();
////            bpm.setText(Float.toString(sequencer.getTempoInBPM()));
////            bpm.setText(Float.toString(sequencer.getTempoFactor()));
//        }
//    }

//    public class MyUpdateTempoKeyListener implements KeyListener {
//        public void keyTyped (KeyEvent keyEvent) {
////            System.out.println(bpmText);
////            sequencer.setTempoFactor(bpmText);
//        }
//
//        public void keyPressed (KeyEvent keyv) {
////            System.out.println(bpmText);
////            sequencer.setTempoFactor(bpmText);
//        }
//        public void keyReleased (KeyEvent kev) {
////            float tempoFactor = sequencer.getTempoFactor();
////            sequencer.setTempoFactor((float) (tempoFactor * 0.97));
//            System.out.println(bpmText);
//            sequencer.setTempoFactor(bpmText);
////            float bpmText = sequencer.getTempoInBPM();
////            bpm.setText(Float.toString(sequencer.getTempoInBPM()));
////            bpm.setText(Float.toString(sequencer.getTempoFactor()));
//        }
//    }

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            // Создаём массив, в котором будут храниться только состояния флажков
            boolean[] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) {
                    checkboxState[i] = true;
                }
            }
            // Сериализуем 2 объекта (строковое сообщение и музыкальный шаблон)
            // и записываем в исходящий поток сокета (на сервер)
            String messageToSend = null;
            try {
                out.writeObject(userName + nextNum++ + ": " + userMessage.getText());
                out.writeObject(checkboxState);
            } catch (Exception ex) {
                System.out.println("Sorry dude. Could not send it to the server.");
            }
            userMessage.setText("");
        }
    }

    /**
     * ListSelectionListener срабатывает, когда пользователь выбирает сообщения из списка.
     * При этом мы сразу загружаем соответствующий шаблон
     *  (хранящийся в переменной otherSeqsMap типа HashMap)
     *  и указываем проиграть его.
     *  Мы добавили несколько условий if из-за особенностей, связанных с получением
     *  событий ListSelectionEvent.
     */

    public class MyListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent le) {
            if (!le.getValueIsAdjusting()) {
                String selected = (String) incomingList.getSelectedValue();
                if (selected != null) {
                    // Переходим к отображению и изменяем последовательность
                    boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    /**
     * Задача потока - читать данные, присылаемые сервером.
     * В этом пкоде под данными понимаются 2 сериализованных объекта:
     * строковое сообщение и музыкальная последовательность(ArrayList с состоянием флажков).
     *
     * Когда приходит сообщение, мы считываем (десериализуем) 2 объекта
     * (само сообщение и ArrayList с булевыми состояниями флажков)
     * и добавляем полученный результат в компонент JList.
     * Добавление происходит в 2 этапа:
     * 1) Помещаем данные списка в объект Vector (устаревший аналог ArrayList)
     * 2) А затем используем его в качестве источника, который говорит
     *    JList что именнно нужно отображать.
     */

    public class RemoteReader implements Runnable {
        boolean[] checkboxState = null;
        String nameToShow = null;
        Object obj = null;
        public void run() {
            try {
                while((obj=in.readObject()) != null) {
                    System.out.println("got an object from server");
                    System.out.println(obj.getClass());
                    String nameToShow = (String) obj;
                    checkboxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkboxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                    // Добавляем диалоговое окно с возможностью сохранить трек
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser Files", "ser");
                    chooser.setFileFilter(filter);
                    int returnVal = chooser.showSaveDialog(mainPanel);
//            File file = chooser.getSelectedFile();
                    try {
                        FileOutputStream fileStream = new FileOutputStream(chooser.getSelectedFile());
                        ObjectOutputStream os = new ObjectOutputStream(fileStream);
                        os.writeObject(checkboxState);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                } // закрываем цикл while
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } // end of run method
    } // end of class

    /**
     * Опустошитель флажков
     */

    public class MyEmptyListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            boolean[] checkboxState = null;
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                check.setSelected(false);
            }
        }
    } // конец внутреннего класса

    /**
     * Этот метод вызывается когда пользователь выбирает пункт из списка.
     * Мы немедленно устанавливаем выбранный шаблон
     */

    public class MyPlayMineListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            if (mySequence != null) {
                sequence = mySequence; // восстановление до оригинальной последовательности
            }
        }
    }

    public void changeSequence(boolean[] checkboxState) {
        for (int i = 0; i < 256; i++) {
            JCheckBox check = (JCheckBox) checkboxList.get(i);
            if (checkboxState[i]) {
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }
    }

    public void makeTracks(ArrayList list) {
        Iterator it = list.iterator();
        for (int i = 0; i < 16; i++) {
            Integer num = (Integer) it.next();
            if (num != null) {
                int numKey = num.intValue();
                track.add(makeEvent(144,9,numKey, 100, i));
                track.add(makeEvent(128,9,numKey,100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }
}

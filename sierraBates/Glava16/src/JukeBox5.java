import java.util.*;
import java.io.*;

/**
 * Created by Steve on 18.12.2015.
 */
public class JukeBox5 {
    String endOfLine;
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox5().go();
    }

    /**
     * Класс для сортировки списка песен по артистам.
     */
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    /**
     * После обработки внешнего тексктового файла, выводим список песен и сортируем его.
     */
    public void go() {
        getSongs();
        System.out.println(songList);

        /**
         * Меняем тип списка для песен на HashSet для удаления дубликатов.
         */
//        HashSet<Song> songSet = new HashSet<Song>();
//        songSet.addAll(songList);
//        System.out.println(songSet);

        /**
         * Сортируем список песен по названию песен.
         */
        Collections.sort(songList);
        System.out.println(songList);
        /**
         * Сортируем список песен по артистам.
         */
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);

        /** Чтобы увидеть как сортировка отработалоа на песнях по артистам
         *  добавляем в sout getArtist() метод.
         *  Также создаём цикл, определяющий когда в выводе запятую ставить, а когда точку
         */
        for (int i = 0; i < songList.size(); i++) {
            if (i == songList.size()-1) {
                endOfLine = ".";
            } else {
                endOfLine = ", ";
            }
            System.out.print(songList.get(i).getArtist() + endOfLine);
        }


        /**
         * На случай переопределения метода toString с показом title + ": " + artist
         * альтернатива показу только имён артистов через запятую.
         */
//        System.out.print(songList);
    }

    /**
     * Получаем внешний файл и читаем его через буффер пока есть песни в файле.
     */
    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Для обработки внешнего текстового файла, разделяем строки
     * по принципу "текст title", "/", "текст artist", "/", "текст rating", "/", " текст bpm".
     * @param lineToParse
     */
    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}

import java.util.*;
import java.io.*;

/**
 * Created by Steve on 20.12.2015.
 */
public class JukeBox8 {
    String endOfLine;
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox8().go();
    }

    /**
     * Класс для сортировки списка песен по артистам.
     */
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    class ArtistCompare2 implements Comparator<Song2> {
        public int compare(Song2 one, Song2 two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    /**
     * Класс для сортировки списка песен по названиям.
     */
    class TitleCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getTitle().compareTo(two.getTitle());
        }
    }

    /**
     * После обработки внешнего тексктового файла, выводим список песен и сортируем его.
     */
    public void go() {
        getSongs();
        System.out.println("В порядке добавления:");
        System.out.println(songList);

        /**
         * Меняем тип списка для песен с ArrayList на TreeSet для удаления дубликатов.
         */
        TreeSet<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);

        /**
         * Сортируем список песен по названию песен.
         */
//        Collections.sort(songList);
//        System.out.println(songList);

        /**
         * Сортируем список песен по названиям.
         */
        TitleCompare titleCompare = new TitleCompare();
//        Collections.sort(songList, titleCompare);
        TreeSet<Song> songSetSortedByTitle = new TreeSet<Song>(titleCompare);
        songSetSortedByTitle.addAll(songSet);
        System.out.println("По названию:");
        System.out.println(songSetSortedByTitle);

        /**
         * Сортируем список песен по артистам.
         */
        ArtistCompare2 artistCompare2 = new ArtistCompare2();
//        Collections.sort(songList, artistCompare);
        TreeSet<Song2> songSetSortedByArtist = new TreeSet<Song2>(artistCompare2);
//        songSetSortedByArtist.addAll(songSet);
        System.out.println("По артисту:");
        System.out.println(songSetSortedByArtist);


        /** Чтобы увидеть как сортировка отработала на песнях по артистам,
         * вызываем переопределённый метод toString с показом только имён артистов.
         */

//        System.out.print(songSetSortedByArtist);


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
            File file = new File("SongListMore.txt");
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

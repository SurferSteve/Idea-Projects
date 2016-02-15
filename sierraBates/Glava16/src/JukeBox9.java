import java.util.*;
import java.io.*;

/**
 * Created by Steve on 21.12.2015.
 */
public class JukeBox9 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox9().go();
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
         * Сортируем список песен по названиям.
         */
        TitleCompare titleCompare = new TitleCompare();
        TreeSet<Song> songSetSortedByTitle = new TreeSet<Song>(titleCompare);
        songSetSortedByTitle.addAll(songSet);
        System.out.println("По названию:");
        System.out.println(songSetSortedByTitle);

        /**
         * Сортируем список песен по артистам.
         */
        ArtistCompare artistCompare = new ArtistCompare();
        TreeSet<Song> songSetSortedByArtist = new TreeSet<Song>(artistCompare);
        songSetSortedByArtist.addAll(songSetSortedByTitle);
        System.out.println("По артисту:");
        System.out.println(songSetSortedByArtist);
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
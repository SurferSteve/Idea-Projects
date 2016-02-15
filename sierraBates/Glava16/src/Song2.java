/**
 * Created by Steve on 20.12.2015.
 */
public class Song2 extends Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song2(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    public String toString() {
        return artist + ": " + title;
    }
}

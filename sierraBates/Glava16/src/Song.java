/**
 * Created by Steve on 18.12.2015.
 */
public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song() {  }

    public boolean equals (Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
//        return title;
        return title + ": " + artist;
    }

//    public String toString2() {
//        toString();
//        return ": " + artist;
//    }
}
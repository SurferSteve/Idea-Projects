package ex0;

/**
 * Created by Steve on 18.05.2016.
 */
public class OurException extends Exception {
    public OurException() {}
    public OurException(String message) {
        super(message);
    }
}

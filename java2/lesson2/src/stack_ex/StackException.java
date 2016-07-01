package stack_ex;

/**
 * Created by Steve on 23.05.2016.
 */
public class StackException extends Exception {
    public StackException(Throwable cause) {
        super(cause);
    }

    public StackException(String message) {
        super(message);
    }

    public StackException() {
    }
}

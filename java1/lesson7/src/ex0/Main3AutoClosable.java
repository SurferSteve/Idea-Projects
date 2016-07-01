package ex0;

import java.io.*;

/**
 * Created by Steve on 18.05.2016.
 */
public class Main3AutoClosable {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")))) {
            br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package finmanager;


import finmanager.DbHelperFinManager;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Steve on 24.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            DbHelperFinManager.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
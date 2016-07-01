package ex5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Steve on 20.05.2016.
 */
public class HttpServer2 {
    public static void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new SocketDispatcher(socket)).start();
        }

//        serverSocket.close();
    }


}

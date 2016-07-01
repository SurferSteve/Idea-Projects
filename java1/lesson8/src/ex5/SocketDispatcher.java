package ex5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Steve on 20.05.2016.
 */
public class SocketDispatcher implements Runnable {
    private Socket socket;

    public SocketDispatcher(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            test(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String html = "<html>" +
                "<head><title>SUPER SERVER a la Apache</title></head>" +
                "<body>" +
                "<h1>Hello, Java!</h1>" +
                "<br/>" +
                "<img src = \"http://cs4.pikabu.ru/post_img/2015/07/20/4/1437370166_1255044967.jpg\">" +
                "</body>" +
                "</html>";

        String header = "HTTP//1.1 200 OK\n" +
                "Content-Type: text/html\n" +
                "Content-Length: " + html.length() + "\n" +
                "Connection: close\n\n";

        String resultText = header + html;

        outputStream.write(resultText.getBytes());
    }
}

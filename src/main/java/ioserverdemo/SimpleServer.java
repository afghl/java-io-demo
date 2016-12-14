package ioserverdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept(); // blocking call

            try (
                InputStream in = s.getInputStream();
                OutputStream out = s.getOutputStream()
                ) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
            }

        }
    }
}

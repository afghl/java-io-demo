package ioserverdemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        ExecutorService service = Executors.newFixedThreadPool(5);
        while (true) {
            Socket s = ss.accept();
            service.submit(() -> Util.process(s));
        }
    }
}

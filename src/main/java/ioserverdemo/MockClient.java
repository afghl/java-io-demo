package ioserverdemo;

import java.io.IOException;
import java.net.Socket;

public class MockClient {
    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            try {
                new Socket("localhost", 8080);
                System.out.println(i);
            } catch (IOException e) {
                System.err.println("could not connect" + e);
            }

        }
    }
}

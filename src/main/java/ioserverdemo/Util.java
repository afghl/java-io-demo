package ioserverdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Util {
    public static void process(Socket s) {
        System.out.println("dealing..." + s);
        try (
                InputStream in = s.getInputStream();
                OutputStream out = s.getOutputStream()
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            System.err.println("Connection problem - " + e);
        }

    }
}

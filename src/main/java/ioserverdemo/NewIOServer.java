package ioserverdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));
        ExecutorService service = Executors.newFixedThreadPool(100);
        while (true) {
            SocketChannel sc = ssc.accept();
            service.submit(() -> {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                try {
                    while (sc.read(buffer) != -1) {
                        buffer.flip();
                        sc.write(buffer);
                        buffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

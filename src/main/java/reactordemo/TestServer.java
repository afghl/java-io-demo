package reactordemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();


        ssc.bind(new InetSocketAddress("localhost", 8080));
        List<SocketChannel> channels = new ArrayList<>();

        ssc.configureBlocking(false);
        System.out.println("server is ready!");


        while (true) {
            SocketChannel sc = ssc.accept();
            System.out.println("sc is " + sc);

        }
    }
}

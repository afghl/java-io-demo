package niodemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by afghl on 16/12/13.
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio.test", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(10);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining())
                System.out.print((char)buf.get());

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }
}

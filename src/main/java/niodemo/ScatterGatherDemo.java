package niodemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ScatterGatherDemo {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        FileOutputStream out = new FileOutputStream("src/main/resources/nio.test");
        FileChannel channel = out.getChannel();
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<ByteBuffer>> results = new ArrayList<Future<ByteBuffer>>();
        ByteBuffer[] buffers = new ByteBuffer[10];
        for (int i = 0; i < 10; i++)
            results.add(service.submit(new BufferGeneractor("task no: " + i)));

        service.shutdown();


        for (int i = 0; i < 10; i++) {
            buffers[i] = results.get(i).get();
        }

        channel.write(buffers);
        out.close();

    }
}

class BufferGeneractor implements Callable<ByteBuffer> {
    private String s;

    BufferGeneractor(String str) {
        s = str;
    }

    public ByteBuffer call() throws Exception {
        ByteBuffer result = ByteBuffer.allocate(s.length());
        result.put(s.getBytes());
        result.flip();
        return result;
    }
}
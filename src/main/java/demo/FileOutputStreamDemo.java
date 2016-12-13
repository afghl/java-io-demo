package demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String s = "FileOutputStreamDemo !!";

        FileOutputStream out = null;

        try {
            out = new FileOutputStream("src/main/resources/fileoutputstreamdemo.test");
            // file output stream 只能写入字节流.
            out.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

package demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    // random access file 允许你读取文件的任何offset量
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("src/main/resources/fileoutputstreamdemo.test", "rw");
            file.seek("FileOutput".length());
            int c;
            while ((c = file.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

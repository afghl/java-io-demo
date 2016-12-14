package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDecoratorDemo {
    public static String read(String path) {
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(path));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = read.readLine()) != null) {
                sb.append(s);
            }

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.printf(read("src/main/resources/ReaderDecoratorDemo.test"));
    }
}

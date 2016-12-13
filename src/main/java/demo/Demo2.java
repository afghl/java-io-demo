package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("src/main/resources/test_file.test");
        FileOutputStream out = new FileOutputStream("src/main/resources/output_test_file.test");
        int c;
        try {
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            in.close();
            out.close();
        }
    }
}

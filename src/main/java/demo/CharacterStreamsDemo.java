package demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by afghl on 16/12/13.
 */
public class CharacterStreamsDemo {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("src/main/resources/fileoutputstreamdemo.test");
            outputStream = new FileWriter("src/main/resources/char_output_.test");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

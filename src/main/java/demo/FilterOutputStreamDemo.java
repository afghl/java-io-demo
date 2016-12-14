package demo;

import java.io.*;

public class FilterOutputStreamDemo {
    public static void main(String[] args) {
        FilterOutputStream out = null;
        try {
            out = new BufferedOutputStream(
                    new FileOutputStream("src/main/resources/test_filter_output_stream.test")
            );
            String s = "i love filter output stream!!";
            out.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

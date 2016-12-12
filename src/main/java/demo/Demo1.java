package demo;

import java.io.File;
import java.io.FilenameFilter;

public class Demo1 {
    public static void main(String[] args) {
        File current = new File(".");
        String[] list = current.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true;
            }
        });

        for (String item : list) {
            System.out.println(item);
        }

    }
}

package niodemo;

import java.io.IOException;
import java.nio.channels.Selector;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        Selector s = Selector.open();
    }
}

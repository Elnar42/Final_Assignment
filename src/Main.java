import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Zoo zoo = new Zoo();
        zoo.loadConfiguration("myZoo.txt");

        zoo.go();
    }
}
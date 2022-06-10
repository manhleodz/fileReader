
import java.io.BufferedReader;
import java.io.FileReader;

public class TextFileReader {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("data.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char)i);
        }
    }
    
}

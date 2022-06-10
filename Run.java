import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run {
    public static void main(String[] args) throws
        IOException {
            FileInputStream in = null;
            FileOutputStream out = null;

            in = new FileInputStream("manh.txt");
            out = new FileOutputStream("ngu.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);

            }
            in.close();
            out.close();

        }
    }

    


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileaddToArrayList {
    

    public static ArrayList<Student> readFromFile() {
        ArrayList<Student> list = new ArrayList<>();

        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String name = txt[0];
                int age = Integer.parseInt(txt[1]);
                double mark  = Double.parseDouble(txt[2]);
                list.add(new Student(name, age, mark));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }


    public static void main(String[] args) {
        ReadFileaddToArrayList main = new ReadFileaddToArrayList();
        ArrayList<Student> list = main.readFromFile();
        for (Student elem : list) {
            System.out.println(elem);
        }
    }
}

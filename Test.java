import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
public class Test {
    
    public static void main(String[] args) {
        Candidate candidate = new Candidate("01", "Doan Duc Manh", "A", "Male", 18, 4);
        Candidate candidate1 = new Candidate("01", "Hien", "A", "Male", 18, 4);
        Candidate candidate2 = new Candidate("01", "Dat", "A", "Male", 18, 4);
        Candidate candidate3 = new Candidate("01", "Toan", "A", "Male", 18, 4);
        ArrayList<Candidate> list = new ArrayList<>();

        list.add(candidate1);
        list.add(candidate2);
        list.add(candidate2);

        list.add(candidate3);

        try {
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Candidate s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

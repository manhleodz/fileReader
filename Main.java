import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Doan Duc Manh", 18, 0.0, "Thai Binh");
        Student st2 = new Student("Doan Duc Manh", 18, 3.0, "Ha Noi");
        Student st3 = new Student("Doan Duc Manh", 18, 3.5, "My Tho");
        Student st4 = new Student("Doan Duc Manh", 18, 2.0, "An Do");
        Student st5 = new Student("Doan Duc Manh", 18, 1.0, "Tau Khua");

        ArrayList<Student> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);

        for (Student s : list) {
            System.out.print(s);
        }

        System.out.println("--------------------------------");
        double max = 0;
        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).getMark()) {
                max = list.get(i).getMark();
                j = i;
            }
        }
        System.out.println(list.get(j).toString());

        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            for (int n = i + 1; n < list.size(); n++) {
                Student s1 = list.get(i);
                Student s2 = list.get(n);

                if (list.get(i).getMark() > list.get(n).getMark()) {
                    list.set(n, s1);
                    list.set(i, s2);
                }
            }
        }

        for (Student o : list) {
            System.out.println(o);
        }
    }
}

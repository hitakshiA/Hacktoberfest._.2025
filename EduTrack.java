import java.util.*;

public class GradeManager {
    static class Student {
        String name;
        List<Integer> grades = new ArrayList<>();
        Student(String name) { this.name = name; }
        void addGrade(int grade) { grades.add(grade); }
        double average() { return grades.stream().mapToInt(g -> g).average().orElse(0.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Student> students = new HashMap<>();
        while (true) {
            System.out.println("1. Add Student\n2. Add Grade\n3. View Average\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                students.put(name, new Student(name));
            } else if (choice == 2) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                if (!students.containsKey(name)) {
                    System.out.println("Student not found");
                    continue;
                }
                System.out.print("Enter grade: ");
                int grade = sc.nextInt();
                students.get(name).addGrade(grade);
            } else if (choice == 3) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                if (!students.containsKey(name)) {
                    System.out.println("Student not found");
                    continue;
                }
                System.out.println("Average: " + students.get(name).average());
            } else if (choice == 4) {
                System.out.println("Goodbye");
                break;
            }
        }
        sc.close();
    }
}


import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    int getHighest() {
        int highest = marks[0];
        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    int getLowest() {
        int lowest = marks[0];
        for (int mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    void displayReport() {
        System.out.println("\nStudent Name: " + name);
        System.out.print("Marks: ");

        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        System.out.println("\nAverage: " + getAverage());
        System.out.println("Highest Marks: " + getHighest());
        System.out.println("Lowest Marks: " + getLowest());
        System.out.println("----------------------------");
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];

            for (int j = 0; j < 5; j++) {
                while (true) {
                    System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                    int mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[j] = mark;
                        break;
                    } else {
                        System.out.println("Enter marks between 0 and 100.");
                    }
                }
            }

            sc.nextLine();
            students.add(new Student(name, marks));
        }

        System.out.println("\n================================");
        System.out.println("       STUDENT REPORT");
        System.out.println("================================");

        for (Student student : students) {
            student.displayReport();
        }

        sc.close();
    }
}
2


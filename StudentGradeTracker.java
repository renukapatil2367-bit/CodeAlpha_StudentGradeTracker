
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> marks;

    Student(String name, ArrayList<Double> marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.size();
    }

    double getHighest() {
        double highest = marks.get(0);
        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }

    double getLowest() {
        double lowest = marks.get(0);
        for (double mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int numberOfStudents = readPositiveInt(sc);

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Enter name: ");
                name = sc.nextLine().trim();
            }

            System.out.print("Enter number of subjects: ");
            int numberOfSubjects = readPositiveInt(sc);

            ArrayList<Double> marks = new ArrayList<>();

            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Enter marks for Subject "
                        + (j + 1) + " (0-100): ");

                double mark = readMark(sc);
                marks.add(mark);
            }

            students.add(new Student(name, marks));
            System.out.println("Student details added successfully!");
        }

        System.out.println("\n=================================");
        System.out.println("        STUDENT REPORT");
        System.out.println("=================================");

        for (Student student : students) {

            System.out.println("\nStudent Name: " + student.name);
            System.out.printf("Average Marks: %.2f%n",
                    student.getAverage());
            System.out.println("Highest Marks: " + student.getHighest());
            System.out.println("Lowest Marks: " + student.getLowest());

            if (student.getAverage() >= 40) {
                System.out.println("Result: PASS");
            } else {
                System.out.println("Result: FAIL");
            }
        }

        System.out.println("\n=================================");
        System.out.println("       OVERALL SUMMARY");
        System.out.println("=================================");
        System.out.println("Total Students: " + students.size());

        Student topper = students.get(0);

        for (Student student : students) {
            if (student.getAverage() > topper.getAverage()) {
                topper = student;
            }
        }

        System.out.println("Topper: " + topper.name);
        System.out.printf("Topper Average: %.2f%n",
                topper.getAverage());

        System.out.println("\nThank you for using Student Grade Tracker!");

        sc.close();
    }

    static int readPositiveInt(Scanner sc) {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine().trim());

                if (value > 0) {
                    return value;
                }

                System.out.print("Please enter a number greater than 0: ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }

    static double readMark(Scanner sc) {
        while (true) {
            try {
                double mark = Double.parseDouble(sc.nextLine().trim());

                if (mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.print("Enter marks between 0 and 100: ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid marks. Enter again: ");
            }
        }
    }
}

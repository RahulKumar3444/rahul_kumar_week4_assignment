import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

    // Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name;
    }
}

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Method to add a student
    public void addStudent(String name, int id) {
        Student student = new Student(name, id);
        students.add(student);
        System.out.println("Student added: " + student);
    }

    // Method to remove a student by ID
    public void removeStudent(int id) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student removed: " + student);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    manager.addStudent(name, id);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeStudent(removeId);
                    break;
                case 3:
                    manager.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}


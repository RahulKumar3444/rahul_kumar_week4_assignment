import java.util.HashMap;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

public class EmployeeManager {
    private HashMap<Integer, Employee> employees = new HashMap<>();

    // Method to add an employee
    public void addEmployee(int id, String name, String department) {
        Employee employee = new Employee(id, name, department);
        employees.put(id, employee);
        System.out.println("Employee added: " + employee);
    }

    // Method to get employee details by ID
    public void getEmployee(int id) {
        if (employees.containsKey(id)) {
            System.out.println(employees.get(id));
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to display all employees
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees.values()) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee department: ");
                    String department = scanner.next();
                    manager.addEmployee(id, name, department);
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int searchId = scanner.nextInt();
                    manager.getEmployee(searchId);
                    break;
                case 3:
                    manager.displayAllEmployees();
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


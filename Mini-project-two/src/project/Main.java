package project;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

class Login {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String user = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();

        return USERNAME.equals(user) && PASSWORD.equals(pass);
    }
}

class EmployeeService {
    private ArrayList<Employee> employees;

    public EmployeeService() {
        employees = FileUtil.loadEmployees();
    }

    public void addEmployee(Employee emp) throws Exception {
        for (Employee e : employees) {
            if (e.getId() == emp.getId()) {
                throw new DuplicateEmployeeException("Employee ID already exists!");
            }
        }
        if (emp.getSalary() <= 0)
            throw new InvalidSalaryException("Salary must be positive!");

        if (emp.getDepartment().isEmpty())
            throw new Exception("Department cannot be empty!");

        employees.add(emp);
        FileUtil.saveEmployees(employees);
    }

    public void displayAll() {
        employees.forEach(System.out::println);
    }

    public Employee searchById(int id) throws Exception {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
    }

    public void updateSalary(int id, double salary) throws Exception {
        if (salary <= 0)
            throw new InvalidSalaryException("Salary must be positive!");

        Employee emp = searchById(id);
        emp.setSalary(salary);
        FileUtil.saveEmployees(employees);
    }

    public void deleteEmployee(int id) throws Exception {
        Employee emp = searchById(id);
        employees.remove(emp);
        FileUtil.saveEmployees(employees);
    }

    public void displaySorted() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    public void displayDepartments() {
        Set<String> departments = new HashSet<>();
        for (Employee e : employees) {
            departments.add(e.getDepartment());
        }
        departments.forEach(System.out::println);
    }
}

class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String msg) {
        super(msg);
    }
}

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) {
        super(msg);
    }
}

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | ₹" + salary;
    }
}


class FileUtil {
    private static final String FILE_NAME = "employees.dat";

    public static void saveEmployees(ArrayList<Employee> list) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Employee> loadEmployees() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!Login.authenticate()) {
            System.out.println("Invalid Login!");
            return;
        }

        EmployeeService service = new EmployeeService();
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Department: ");
                        String dept = sc.next();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        service.addEmployee(new Employee(id, name, dept, sal));
                        System.out.println("Employee added successfully!");
                    }
                    case 2 -> service.displayAll();
                    case 3 -> {
                        System.out.print("Enter ID: ");
                        System.out.println(service.searchById(sc.nextInt()));
                    }
                    case 4 -> {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("New Salary: ");
                        service.updateSalary(id, sc.nextDouble());
                        System.out.println("Salary updated!");
                    }
                    case 5 -> {
                        System.out.print("Enter ID: ");
                        service.deleteEmployee(sc.nextInt());
                        System.out.println("Employee deleted!");
                    }
                    case 6 -> service.displaySorted();
                    case 7 -> service.displayDepartments();
                    case 8 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 8);
    }
}


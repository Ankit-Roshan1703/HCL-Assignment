package project;

import java.io.*;
import java.util.*;

import java.io.Serializable;

class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}

class Student implements Serializable, Comparable<Student> {
    private int eno;
    private String name;
    private String branch;
    private int sem;
    private double percentage;

    public Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public int getEno() {
        return eno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public int compareTo(Student s) {
        return this.eno - s.eno;
    }

    @Override
    public String toString() {
        return eno + " | " + name + " | " + branch + " | Sem " + sem + " | " + percentage + "%";
    }
}


public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        loadData();
        login();

        int choice;
        do {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateBranch();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> saveData();
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 7);
    }

    // 🔐 Login
    static void login() {
        String user, pass;
        while (true) {
            System.out.print("Username: ");
            user = sc.next();
            System.out.print("Password: ");
            pass = sc.next();

            if (user.equals("admin") && pass.equals("admin123")) {
                System.out.println("Login Successful!");
                break;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    // ➕ Add Student
    static void addStudent() throws InvalidStudentException {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno)
                throw new InvalidStudentException("Eno must be unique!");
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        if (branch.isEmpty())
            throw new InvalidStudentException("Branch cannot be empty!");

        System.out.print("Enter Semester: ");
        int sem = sc.nextInt();

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();
        if (per <= 0)
            throw new InvalidStudentException("Percentage must be positive!");

        students.add(new Student(eno, name, branch, sem, per));
        System.out.println("Student Added Successfully!");
    }

    //  Display Students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found!");
            return;
        }
        students.forEach(System.out::println);
    }

    //  Search Student
    static void searchStudent() throws InvalidStudentException {
        System.out.print("Enter Eno to search: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.println(s);
                return;
            }
        }
        throw new InvalidStudentException("Student not found!");
    }

    //  Update Branch
    static void updateBranch() throws InvalidStudentException {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.print("Enter new branch: ");
                String branch = sc.nextLine();
                if (branch.isEmpty())
                    throw new InvalidStudentException("Branch cannot be empty!");
                s.setBranch(branch);
                System.out.println("Branch updated successfully!");
                return;
            }
        }
        throw new InvalidStudentException("Student not found!");
    }

    //  Delete Student
    static void deleteStudent() throws InvalidStudentException {
        System.out.print("Enter Eno to delete: ");
        int eno = sc.nextInt();

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            if (itr.next().getEno() == eno) {
                itr.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        throw new InvalidStudentException("Student not found!");
    }

    //  Sort Students
    static void sortStudents() {
        Collections.sort(students);
        displayStudents();
    }

    //  File Handling
    static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving data!");
        }
    }

    static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }
}

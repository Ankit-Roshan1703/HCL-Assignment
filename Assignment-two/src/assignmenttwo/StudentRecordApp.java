package assignmenttwo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.Scanner;

interface StudentOperations {
    void addStudent(Student student);
    void displayStudents();
    void removeStudent(int rollNo);
    Student searchStudent(int rollNo);
}

class Student {
    private int rollNo;
    private String name;
    private int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

class StudentManager implements StudentOperations {

    private List<Student> studentList = new ArrayList<>();

    private Vector<Student> backupVector = new Vector<>();

    private static final String NAME_REGEX = "^[A-Za-z ]+$";

    @Override
    public void addStudent(Student student) {
        if (!Pattern.matches(NAME_REGEX, student.getName())) {
            throw new IllegalArgumentException("Invalid name format");
        }
        studentList.add(student);
        backupVector.add(student);
        System.out.println("Student added successfully");
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Override
    public void removeStudent(int rollNo) {
        Iterator<Student> iterator = studentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            if (iterator.next().getRollNo() == rollNo) {
                iterator.remove();
                found = true;
                System.out.println("Student removed successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }
}

public class StudentRecordApp {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            manager.addStudent(new Student(1, "Ankit", 85));
            manager.addStudent(new Student(2, "Rohit", 78));

            System.out.println("\nAll Students:");
            manager.displayStudents();

            System.out.println("\nSearching Roll No 1:");
            Student s = manager.searchStudent(1);
            System.out.println(s != null ? s : "Student not found");

            System.out.println("\nRemoving Roll No 2:");
            manager.removeStudent(2);

            System.out.println("\nUpdated Student List:");
            manager.displayStudents();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e);
        } finally {
            sc.close();
        }
    }
}

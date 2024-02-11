import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter student name (or type 'exit' to finish):");
            String name = scanner.nextLine();
            if ("exit".equalsIgnoreCase(name)) break;

            System.out.println("Enter student address:");
            String address = scanner.nextLine();

            double GPA = 0.0;
            while (true) {
                System.out.println("Enter student GPA:");
                try {
                    GPA = Double.parseDouble(scanner.nextLine());
                    if (GPA < 0.0 || GPA > 4.0) {
                        System.out.println("Please enter a valid GPA between 0.0 and 4.0.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value for GPA.");
                }
            }

            studentList.add(new Student(name, address, GPA));
        }

        Collections.sort(studentList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
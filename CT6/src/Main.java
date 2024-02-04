import java.util.ArrayList;
import java.util.Comparator;

class Student { // Corrected the class name to start with an uppercase letter
    int rollno;
    String name;
    String address;

    // Constructor
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // toString method for printing student details
    @Override
    public String toString() {
        return this.rollno + " " + this.name + " " + this.address;
    }
}

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

class SortByRollNo implements Comparator<Student> { // Corrected the generic type to Student
    @Override
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

class StudentSorter {
    public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
        for (int i = 0; i < students.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < students.size(); j++) {
                if (comparator.compare(students.get(j), students.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }
            Student temp = students.get(minIdx);
            students.set(minIdx, students.get(i));
            students.set(i, temp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(8, "Ryan", "MO"));
        students.add(new Student(3, "Ethan", "PA"));
        students.add(new Student(5, "Andrew", "NC"));
        students.add(new Student(1, "Matt", "WA"));
        students.add(new Student(4, "Taylor", "FL"));
        students.add(new Student(10, "Chris", "CA"));
        students.add(new Student(2, "Amber", "TX")); // Corrected typo here
        students.add(new Student(9, "Chelsea", "SC"));
        students.add(new Student(7, "Hannah", "GA"));
        students.add(new Student(6, "Abby", "OH")); // Corrected typo here


        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by name
        StudentSorter.selectionSort(students, new SortByName());
        System.out.println("\nAfter sorting by name:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by roll number
        StudentSorter.selectionSort(students, new SortByRollNo());
        System.out.println("\nAfter sorting by roll number:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

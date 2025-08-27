package model;

import java.util.ArrayList;
import java.util.List;

public class UniClass {
    private String name;
    private String classroom;
    private Professor professor;
    private List<Student> students;

    public UniClass(String name, String classroom, Professor professor) {
        this.name = name;
        this.classroom = classroom;
        this.professor = professor;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        try {
            if (student != null) {
                students.add(student);
            } else {
                throw new IllegalArgumentException("Student cannot be null :( ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "UniClass{" +
                "name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", professor=" + professor.getName() +
                ", students=" + students.size() +
                '}';
    }

    //print students with more detail
    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in this class :0");
        } else {
            System.out.println("Students in " + name + ":");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}


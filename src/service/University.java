package model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Professor> professors;
    private List<Student> students;
    private List<UniClass> classes;

    public University(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<UniClass> getClasses() {
        return classes;
    }

    /*----------------CRUD METHODS----------------*/

    //Professors
    public void addProfessor(Professor professor) {
        if (professor != null) {
            professors.add(professor);
        }
    }

    public void listProfessors() {
        if (professors.isEmpty()) {
            System.out.println("No professors registered :( ");
        } else {
            for (Professor p : professors) {
                System.out.println(p);
            }
        }
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

   public void addClass(UniClass uniClass) {
        if (uniClass != null) {
            classes.add(uniClass);
        }
    }

    public void listClasses() {
        if (classes.isEmpty()) {
            System.out.println("No classes registered :( ");
        } else {
            for (UniClass c : classes) {
                System.out.println(c);
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}

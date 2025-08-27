package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void printClasses(Scanner scanner) {
        if (classes.isEmpty()) {
            System.out.println("No classes registered.");
            return;
        }

        System.out.println("\nAvailable classes:");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ") " + classes.get(i).getName());
        }

        System.out.print("Choose a class number to see details (0 to go back): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= classes.size()) {
            UniClass selected = classes.get(choice - 1);
            System.out.println("\nClass: " + selected.getName());
            System.out.println("Teacher: " + selected.getProfessor().getName());
            System.out.println("Students:");
            for (Student s : selected.getStudents()) {
                System.out.println("- " + s.getName() + " (ID: " + s.getId() + ")");
            }
        } else if (choice != 0) {
            System.out.println("Invalid option.");
        }
    }

    public void createStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        Student newStudent = new Student(name, id);
        students.add(newStudent);

        // Ask where to add this student
        if (!classes.isEmpty()) {
            System.out.println("\nSelect a class to add the student:");
            for (int i = 0; i < classes.size(); i++) {
                System.out.println((i + 1) + ") " + classes.get(i).getName());
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= classes.size()) {
                classes.get(choice - 1).addStudent(newStudent);
                System.out.println("Student added successfully to class " + classes.get(choice - 1).getName());
            } else {
                System.out.println("Invalid class selection. Student created but not assigned.");
            }
        } else {
            System.out.println("No classes available. Student created but not assigned.");
        }
    }

    public void createClass(Scanner scanner) {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        // Select a teacher
        if (professors.isEmpty()) {
            System.out.println("No professors available. Please create professors first.");
            return;
        }
        System.out.println("\nSelect a professor for this class:");
        for (int i = 0; i < professors.size(); i++) {
            System.out.println((i + 1) + ") " + professors.get(i).getName());
        }
        int profChoice = scanner.nextInt();
        scanner.nextLine();
        Professor chosenProf = professors.get(profChoice - 1);

        // Select students
        List<Student> chosenStudents = new ArrayList<>();
        if (!students.isEmpty()) {
            System.out.println("\nSelect students for this class (enter numbers separated by commas):");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ") " + students.get(i).getName());
            }
            String input = scanner.nextLine();
            String[] indices = input.split(",");
            for (String idx : indices) {
                try {
                    int studentIdx = Integer.parseInt(idx.trim());
                    if (studentIdx > 0 && studentIdx <= students.size()) {
                        chosenStudents.add(students.get(studentIdx - 1));
                    }
                } catch (NumberFormatException e) {
                    // ignore invalid numbers
                }
            }
        }

        UniClass newClass = new UniClass(className, chosenProf, chosenStudents);
        classes.add(newClass);

        System.out.println("Class " + className + " created successfully!");
    }







}

package util;

import model.*;
import service.University;

import java.util.Arrays;

public class DataInitializer {

    public static service.University initializeUniversity() {
        service.University university = new University("Universidad Nacional de Colombia");


        Professor full1 = new FullTimeProfessor("Shakira", 3000, 32); // fulltime
        Professor full2 = new FullTimeProfessor("Carlos Vives", 2800, 12); // fulltime
        Professor part1 = new PartTimeProfessor("Maluma", 120, 34, 23); // parttime
        Professor part2 = new PartTimeProfessor("J Balvin", 100, 21, 45); // parttime

        university.addProfessor(full1);
        university.addProfessor(full2);
        university.addProfessor(part1);
        university.addProfessor(part2);


        Student s1 = new Student("S001", "Karol G", 22);
        Student s2 = new Student("S002", "Greeicy Rendón", 21);
        Student s3 = new Student("S003", "Sebastián Yatra", 23);
        Student s4 = new Student("S004", "Sofía Vergara", 20);
        Student s5 = new Student("S005", "James Rodríguez", 24);
        Student s6 = new Student("S006", "Westcol de Jesús", 19);

        university.addStudent(s1);
        university.addStudent(s2);
        university.addStudent(s3);
        university.addStudent(s4);
        university.addStudent(s5);
        university.addStudent(s6);


        UniClass c1 = new UniClass("Matemáticas I", "Salón 101", full1, Arrays.asList(s1, s2));
        UniClass c2 = new UniClass("Historia de Colombia", "Salón 202", full2, Arrays.asList(s3, s4));
        UniClass c3 = new UniClass("Programación Avanzada", "Lab 301", part1, Arrays.asList(s5, s6));
        UniClass c4 = new UniClass("Física Moderna", "Salón 303", part2, Arrays.asList(s1, s3, s5));

        university.addClass(c1);
        university.addClass(c2);
        university.addClass(c3);
        university.addClass(c4);

        return university;
    }
}

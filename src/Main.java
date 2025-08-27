package app;

import model.University;
import util.DataInitializer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = DataInitializer.initUniversity();
        Scanner scanner = new Scanner(System.in);
        int elect;

        do {
            System.out.println("\n(っ◔◡◔)っ Welcome to the Nacional University System");
            System.out.println("1) (•◡•)/ Show me all professors");
            System.out.println("2) (¬‿¬) Show me all classes");
            System.out.println("3) (ᵔᴥᵔ) Create a new student");
            System.out.println("4) (ง'̀-'́)ง Create a new class");
            System.out.println("5) (◕‿◕✿) Find classes by student ID");
            System.out.println("6) (⌐■_■) Exit");
            System.out.print("Choose an option: ");
            elect = scanner.nextInt();
            scanner.nextLine();

            switch (elect) {
                case 1:
                    university.printTeachers();
                    break;
                case 2:
                    university.printClasses();
                    break;
                case 3:
                    university.createStudent(scanner);
                    break;
                case 4:
                    university.createClass(scanner);
                    break;
                case 5:
                    university.findClassesByStudent(scanner);
                    break;
                case 6:
                    System.out.println("Goodbye ヽ(ˇヘˇ)ノ");
                    break;
                default:
                    System.out.println("Invalid option (╯°□°）╯︵ ┻━┻");
            }
        } while (elect != 6);

        scanner.close();
    }
}

/*
  Hauen-Limkilde, Marcus
  Shaker, Tim     

  May 6, 2024

  CS A170
  Project 3
*/

import java.util.*;

/**
 * This program manages a student directory for Orange Coast College.
 * It allows users to add students with their grades, remove students, list all
 * students,
 * and list students who made it to the Dean's List based on their grades.
 */
public class StudentDirectory {
    /**
     * The main method that runs the program.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> grade = new ArrayList<String>();
        boolean key = true;
        Scanner in = new Scanner(System.in);

        while (key == true) {
            printMenu();
            String choice = in.next();
            switch (choice) {
                case "1":
                    addStudentGrade(name, grade);
                    break;
                case "2":
                    removeStudent(name);
                    break;
                case "3":
                    listStudents(name, grade);
                    break;
                case "4":
                    deansList(name, grade);
                    break;
                case "5":
                    System.out.println("Exiting the program. Goodbye!");
                    key = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        in.close();
    }

    /**
     * Prints the menu options to the console.
     */
    public static void printMenu() {
        System.out.print("Orange Coast College Student Directory\n" +
                "--------------------------------------\n" +
                "1. Add Student and Grade\n" +
                "2. Remove Student\n" +
                "3. List Students\n" +
                "4. Dean's List\n" +
                "5. Exit\n" +
                "Select an option: ");
    }

    /**
     * Adds a new student to the directory.
     * 
     * @param students The list of students
     * @param in       Scanner object to read user input
     */
    public static ArrayList<String> addStudentGrade(ArrayList<String> name, ArrayList<String> grade) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the student's name: ");
        name.add(in.next());
        System.out.print("Enter the student's grade: ");
        grade.add(in.next());
        System.out.println(
                name.get(grade.size() - 1) + " with grade " + grade.get(grade.size() - 1) + " added to the list.");
        return name;
    }

    /**
     * Removes a student from the directory.
     * 
     * @param students The list of students
     * @param in       Scanner object to read user input
     */
    public static ArrayList<String> removeStudent(ArrayList<String> name) {
        String n;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the student's name to remove: ");
        n = in.next();
        int index = name.indexOf(n);
        if (index != -1) {
            name.remove(index);
            System.out.println(n + " has been removed from the list.");
        } else {
            System.out.println(n + " was not found in the list.");
        }
        return name;
    }

    /**
     * Lists all students in the directory.
     * 
     * @param students The list of students
     */
    public static void listStudents(ArrayList<String> name, ArrayList<String> grade) {
        System.out.println("Student List:");
        int k = 0;
        for (String i : name) {
            System.out.println(i + " - Grade: " + grade.get(k));
            k++;
        }
    }

    /**
     * Lists students who made it to the Dean's List (grade >= 90).
     * 
     * @param students The list of students
     */
    public static void deansList(ArrayList<String> name, ArrayList<String> grade) {
        System.out.println("Dean's List:");
        int k = 0;

        for (String i : name) {
            if (Integer.parseInt(grade.get(k)) >= 90) {
                System.out.println(i + " - Grade: " + grade.get(k));
            }
            k++;
        }

    }
}

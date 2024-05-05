import java.util.ArrayList;
import java.util.Scanner;

public class StudentDirectory {
	ArrayList<String> studentNames;
	ArrayList<Integer> studentGrades;

	public StudentDirectory() {
		this.studentNames = new ArrayList<String>();
		this.studentGrades = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentDirectory dir = new StudentDirectory();
		boolean exit = false;

		while (!exit) {
			printMenu();
			int option = in.nextInt();
			switch (option) {
				case 1:
					dir.addStudent();
					break;
				case 2:
					dir.removeStudent();
					break;
				case 3:
					dir.listStudents();
					break;
				case 4:
					dir.printDeansList();
					break;
				case 5:
					exit = true;
					break;

				default:
					break;
			}
		}

		System.out.println("Exiting the program. Goodbye!");
		in.close();
	}

	public static void printMenu() {
		System.out.println("Orange Coast College Student Directory");
		System.out.println("--------------------------------------");
		System.out.println("1. Add Student and Grade");
		System.out.println("2. Remove Student");
		System.out.println("3. List Students");
		System.out.println("4. Dean's List");
		System.out.println("5. Exit");
		System.out.print("Select an option: ");
	}

	public void addStudent() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the student's name: ");
		String name = in.nextLine();
		studentNames.add(name);

		System.out.print("Enter the student's grade: ");
		int grade = in.nextInt();
		studentGrades.add(grade);
		System.out.println(name + " with grade " + grade + " added to the list.");

	}

	public void removeStudent() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the student's name to remove: ");
		String name = in.nextLine();
		int index = studentNames.indexOf(name);
		if (index == -1) {
			System.out.println(name + " was not found in the list.");
		} else {
			studentNames.remove(index);
			studentGrades.remove(index);
			System.out.println(name + " has been removed from the list.");
		}

	}

	public void listStudents() {
		System.out.println("Student List:");
		for (int i = 0; i < studentNames.size(); i++) {
			System.out.println(studentNames.get(i) + " - Grade: " + studentGrades.get(i));
		}
	}

	public void printDeansList() {
		System.out.println("Dean's List:");
		for (int i = 0; i < studentNames.size(); i++) {
			if (studentGrades.get(i) >= 90) {
				System.out.println(studentNames.get(i) + " - Grade: " + studentGrades.get(i));
			}
		}
	}
}
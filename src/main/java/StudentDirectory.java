import java.util.ArrayList;
import java.util.Scanner;

public class StudentDirectory {
	double[][] data;
	ArrayList<String> studentNames;
	ArrayList<Integer> studentGrades;

	public StudentDirectory(int numStudents, int numAssignments) {
		this.data = new double[numStudents][numAssignments];
		this.studentNames = new ArrayList<String>();
		this.studentGrades = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StudentDirectory dir = new StudentDirectory(3, 3);
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
					dir.listStudent();
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

	public void listStudent() {
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

	public static void printData(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;

		// print table header
		System.out.print("          | ");
		for (int i = 0; i < COLS; i++) {
			System.out.print("Assignment " + i + " | ");
		}
		System.out.print("Highest      | ");
		System.out.print("Lowest       | ");
		System.out.print("Total        | ");
		System.out.println();
		for (int i = 0; i < 11 + (COLS + 3) * 15; i++) {
			System.out.print("-");
		}
		System.out.println();

		// print table body
		for (int i = 0; i < ROWS; i++) {
			System.out.print("Student " + i + " | ");
			for (int j = 0; j < COLS; j++) {
				System.out.printf("%12.2f | ", data[i][j]);
			}
			System.out.printf("%12.2f | ", getHighestInRow(data, i));
			System.out.printf("%12.2f | ", getLowestInRow(data, i));
			System.out.printf("%12.2f | ", getRowTotal(data, i));
			System.out.println();
		}

		// print column totals
		System.out.print("Total     | ");
		for (int i = 0; i < COLS; i++) {
			System.out.printf("%12.2f | ", getColumnTotal(data, i));
		}
		System.out.println();

		for (int i = 0; i < 11 + (COLS + 3) * 15; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println("Total: " + getTotal(data));
		System.out.printf("Average: %.2f ", getAverage(data));
	}

	public static void populateData(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				data[i][j] = Math.round(Math.random() * 100);
			}
		}
	}

	public static double getTotal(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;
		double total = 0;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				total += data[i][j];
			}
		}

		return total;
	}

	public static double getAverage(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;
		double total = getTotal(data);

		return total / (ROWS * COLS);
	}

	public static double getRowTotal(double[][] data, int row) {
		final int COLS = data[row].length;
		double total = 0;

		for (int i = 0; i < COLS; i++) {
			total += data[row][i];
		}

		return total;
	}

	public static double getColumnTotal(double[][] data, int col) {
		final int ROWS = data.length;
		double total = 0;

		for (int i = 0; i < ROWS; i++) {
			total += data[i][col];
		}

		return total;
	}

	public static double getHighestInRow(double[][] data, int row) {
		final int COLS = data[row].length;
		double max = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < COLS; i++) {
			max = Math.max(max, data[row][i]);
		}

		return max;
	}

	public static double getLowestInRow(double[][] data, int row) {
		final int COLS = data[row].length;
		double min = Double.POSITIVE_INFINITY;

		for (int i = 0; i < COLS; i++) {
			min = Math.min(min, data[row][i]);
		}

		return min;
	}

}
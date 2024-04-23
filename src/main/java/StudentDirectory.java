public class StudentDirectory {
	double[][] data;

	public StudentDirectory(int numStudents, int numAssignments) {
		this.data = new double[numStudents][numAssignments];
	}

	public static void main(String[] args) {
		StudentDirectory directory = new StudentDirectory(3, 3);
		populateData(directory.data);
		printData(directory.data);
	}

	public static void printData(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.printf("%10.2f ", data[i][j]);
			}
			System.out.println();
		}

		System.out.println("============================");
		System.out.println("Total: " + getTotal(data));
		System.out.printf("Average: %.2f ", getAverage(data));
	}

	public static void populateData(double[][] data) {
		final int ROWS = data.length;
		final int COLS = data[0].length;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				data[i][j] = Math.round(Math.random() * 100.0);
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
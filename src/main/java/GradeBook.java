import static org.junit.Assert.assertEquals;

public class GradeBook {
    double[][] grades;

    public GradeBook(int numStudents, int numAssignments) {
        this.grades = new double[numStudents][numAssignments];
    }

    public static void main(String[] args) {
        GradeBook book = new GradeBook(3, 3);
        populateData(book.grades);
        printTable(book.grades);
        test(book.grades);
    }

    public static void test(double[][] data) {
        System.out.println("Tests:");
        final double delta = 0.001; // delta value for comparing doubles

        // Test Row 2
        double highestInRow = getHighestInRow(data, 1);
        System.out.println("Highest in Row 2: " + highestInRow);
        assertEquals(6, highestInRow, delta);

        double lowestInRow = getLowestInRow(data, 1);
        System.out.println("Lowest in Row 2: " + lowestInRow);
        assertEquals(4, lowestInRow, delta);

        double rowTotal = getRowTotal(data, 1);
        System.out.println("Row 2 Total: " + rowTotal);
        assertEquals(15, rowTotal, delta);

        // Test Last Column
        double columnTotal = getColumnTotal(data, 2);
        System.out.println("Column 3 Total: " + columnTotal);
        assertEquals(18, columnTotal, delta);

        // Total and Average
        double total = getTotal(data);
        System.out.println("Total: " + total);
        assertEquals(45, total, delta);

        double average = getAverage(data);
        System.out.println("Average: " + average);
        assertEquals(5, average, delta);
    }

    public static void printTable(double[][] data) {
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
    }

    public static void populateData(double[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        final int[][] testData = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                data[i][j] = testData[i][j];
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
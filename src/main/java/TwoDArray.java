/*
  Hauen-Limkilde, Marcus
  Shaker, Tim     

  May 6, 2024

  CS A170
  Project 3
*/

public class TwoDArray {

    /**
     * Creates an empty 2D integer array, populates it with data, prints the data,
     * and displays test values.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[][] data = new int[3][3];
        populateData(data);
        printTable(data);
        test(data);
    }

    /**
     * Displays test values for testing the class.
     * 
     * @param data a 2D integer array
     */
    public static void test(int[][] data) {
        int total = getTotal(data);
        System.out.println("The total of these values is: " + total);

        double average = getAverage(data);
        System.out.println("The average of elements in this 2-dimensional array is: " + average);

        int rowTotal = getRowTotal(data, 1);
        System.out.println("The total of values in row #2 is " + rowTotal);

        int columnTotal = getColumnTotal(data, 2);
        System.out.println("The total values in column #3 is " + columnTotal);

        int highestInRow = getHighestInRow(data, 1);
        System.out.println("The highest value in row #2 is " + highestInRow);

        int lowestInRow = getLowestInRow(data, 1);
        System.out.println("The lowest value in row #2 is " + lowestInRow);
    }

    /**
     * Prints all the values of the array in a table format.
     * 
     * @param data a 2D integer array
     */
    public static void printTable(int[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        System.out.println("The elements in this 2-dimensional array are:");

        // print table body
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Populates the data array with test data.
     * 
     * @param data a 2D integer array
     */
    public static void populateData(int[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        final int[][] testData = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                data[i][j] = testData[i][j];
            }
        }
    }

    /**
     * Calculates the total of all the values in the 2D array.
     * 
     * @param data a 2D integer array
     * @return the total of all the values in the 2D array
     */
    public static int getTotal(int[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        int total = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                total += data[i][j];
            }
        }

        return total;
    }

    /**
     * Gets the average of all the values in the 2D array.
     * 
     * @param data a 2D integer array
     * @return the average of all the values in the 2D array
     */
    public static double getAverage(int[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        double total = getTotal(data);

        return total / (ROWS * COLS);
    }

    /**
     * Calculates the total of all the values in a row.
     * 
     * @param data a 2D integer array
     * @param row  the row to calculate the total of
     * @return the total of all the values in the row
     */
    public static int getRowTotal(int[][] data, int row) {
        final int COLS = data[row].length;
        int total = 0;

        for (int i = 0; i < COLS; i++) {
            total += data[row][i];
        }

        return total;
    }

    /**
     * Calculates the total of all the values in a column.
     * 
     * @param data a 2D integer array
     * @param col  the column to calculate the total of
     * @return the total of all the values in the column
     */
    public static int getColumnTotal(int[][] data, int col) {
        final int ROWS = data.length;
        int total = 0;

        for (int i = 0; i < ROWS; i++) {
            total += data[i][col];
        }

        return total;
    }

    /**
     * Finds the highest value in a row.
     * 
     * @param data a 2D integer array
     * @param row  the row to find the highest value of
     * @return the highest value in the row
     */
    public static int getHighestInRow(int[][] data, int row) {
        final int COLS = data[row].length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < COLS; i++) {
            max = Math.max(max, data[row][i]);
        }

        return max;
    }

    /**
     * Finds the lowest value in a row.
     * 
     * @param data a 2D integer array
     * @param row  the row to find the lowest value of
     * @return the lowest value in the row
     */
    public static int getLowestInRow(int[][] data, int row) {
        final int COLS = data[row].length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < COLS; i++) {
            min = Math.min(min, data[row][i]);
        }

        return min;
    }

}
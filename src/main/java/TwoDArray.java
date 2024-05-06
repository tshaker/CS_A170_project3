/*
  Hauen-Limkilde, Marcus
  Shaker, Tim     

  May 6, 2024

  CS A170
  Project 3
*/

public class TwoDArray {

    public static void main(String[] args) {
        int[][] grades = new int[3][3];
        populateData(grades);
        printTable(grades);
        test(grades);
    }

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

    public static double getAverage(int[][] data) {
        final int ROWS = data.length;
        final int COLS = data[0].length;
        double total = getTotal(data);

        return total / (ROWS * COLS);
    }

    public static int getRowTotal(int[][] data, int row) {
        final int COLS = data[row].length;
        int total = 0;

        for (int i = 0; i < COLS; i++) {
            total += data[row][i];
        }

        return total;
    }

    public static int getColumnTotal(int[][] data, int col) {
        final int ROWS = data.length;
        int total = 0;

        for (int i = 0; i < ROWS; i++) {
            total += data[i][col];
        }

        return total;
    }

    public static int getHighestInRow(int[][] data, int row) {
        final int COLS = data[row].length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < COLS; i++) {
            max = Math.max(max, data[row][i]);
        }

        return max;
    }

    public static int getLowestInRow(int[][] data, int row) {
        final int COLS = data[row].length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < COLS; i++) {
            min = Math.min(min, data[row][i]);
        }

        return min;
    }

}
import java.util.Scanner;

public class Determinant {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.println("Metrix A");
        System.out.print("[n x n]  n = ");

        int RC = scan.nextInt(); // RC = Row and Column
        System.out.println();

        int A[][] = new int[RC][RC];

        // Input Metrix A
        System.out.println("Metrix A");
        System.out.println("A[row][column]");
        System.out.println();

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]  = ");
                A[i][j] = scan.nextInt();
            }
            System.out.println();
        }

        // Output Metrix A
        System.out.println("Metrix A");

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Determinant Metrix A : " + Det(A));
        System.out.println();
    }

    public static int Det(int[][] matrix) {

        // findDet = findDeterminant

        int size = matrix.length;
        int DetA = 0;

        for (int i = 0; i < size; i++) {

            if (size > 2) {

                DetA += matrix[i][0] * Math.pow(-1, i) * Det(Minors(i, 0, matrix));
                // Cofactors = Math.pow(-1, i) * Determinant(Minors(i, 0, matrix))

            } else if (size == 2) {
                DetA = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

            } else if (size == 1) {
                DetA = matrix[0][0];

            }

        }
        return DetA;

    }

    public static int[][] Minors(int row, int column, int[][] matrix) {

        // DelRC = delete Row and Column

        int oldSize = matrix.length;
        int newSize = oldSize - 1;

        int[][] tempMatrix = new int[newSize][oldSize];
        int[][] newMatrix = new int[newSize][newSize];

        // -------------------------------------------------------

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < oldSize; j++) {
                tempMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = row; i < newSize; i++) {
            for (int j = 0; j < oldSize; j++) {
                tempMatrix[i][j] = matrix[i + 1][j];
            }
        }
        // -------------------------------------------------------

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix[i][j] = tempMatrix[i][j];
            }
        }

        for (int i = 0; i < newSize; i++) {
            for (int j = column; j < newSize; j++) {
                newMatrix[i][j] = tempMatrix[i][j + 1];
            }
        }
        return newMatrix;

        // -------------------------------------------------------
    }
}

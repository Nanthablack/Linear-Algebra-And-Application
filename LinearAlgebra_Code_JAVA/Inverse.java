import java.util.*;

class Inverse {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.println("Matrix A");
        System.out.print("[n x n]  n = ");

        int RC = scan.nextInt(); // RC = Row and Column
        System.out.println();

        int A[][] = new int[RC][RC];

        // Input Metrix A
        System.out.println("Matrix A");
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
        System.out.println("Matrix A");

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        float[][] Adj = new float[RC][RC];

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                Adj[i][j] = Cofactors(i, j, A);
            }
        }
        if (Det(A) == 0) {

            System.out.println("Inverse Matrix\n");
            System.out.println("Empty!\n");

        } else {

            System.out.println("Inverse Matrix");
            for (int i = 0; i < RC; i++) {
                for (int j = 0; j < RC; j++) {
                    System.out.printf("%.2f\t", (Adj[j][i] / Det(A)));
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static float Cofactors(int row, int column, int[][] A) {

        return (float) (Math.pow(-1, (row + column + 2)) * Det(Minors(row, column, A)));
    }

    public static int[][] Minors(int row, int column, int[][] matrix) {

        int oldSize = matrix.length;
        int newSize = oldSize - 1;

        int[][] tempMatrix = new int[newSize][oldSize];
        int[][] newMatrix = new int[newSize][newSize];

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
    }

    public static int Det(int[][] matrix) {

        int size = matrix.length;
        int DetA = 0;

        for (int i = 0; i < size; i++) {

            if (size > 2) {

                DetA += matrix[i][0] * Math.pow(-1, i) * Det(Minors(i, 0, matrix));
            } else if (size == 2) {

                DetA = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            } else if (size == 1) {

                DetA = matrix[0][0];
            }
        }
        return DetA;
    }

}
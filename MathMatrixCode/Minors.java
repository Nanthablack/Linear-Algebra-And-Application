import java.util.*;

class Minors {
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

        if (RC == 1) {
            System.out.println("Minors[1][1]\nEmpty! ");
            System.out.println();
        } else {
            for (int i = 1; i <= RC; i++) {
                for (int j = 1; j <= RC; j++) {
                    System.out.println("Minors[" + i + "][" + j + "]");
                    for (int n = 0; n < RC - 1; n++) {
                        for (int m = 0; m < RC - 1; m++) {
                            System.out.print(Minors(i, j, A)[n][m] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] Minors(int row, int column, int[][] matrix) {

        int oldSize = matrix.length;
        int newSize = oldSize - 1;

        int[][] tempMatrix = new int[newSize][oldSize];
        int[][] newMatrix = new int[newSize][newSize];

        // -------------------------------------------------------

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < oldSize; j++) {
                tempMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = row - 1; i < newSize; i++) {
            for (int j = 0; j < oldSize; j++) {
                tempMatrix[i][j] = matrix[i + 1][j];
            }
        }
        // -------------------------------------------------------

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < column - 1; j++) {
                newMatrix[i][j] = tempMatrix[i][j];
            }
        }

        for (int i = 0; i < newSize; i++) {
            for (int j = column - 1; j < newSize; j++) {
                newMatrix[i][j] = tempMatrix[i][j + 1];
            }
        }
        return newMatrix;

        // -------------------------------------------------------
    }
}

import java.util.*;

public class Transpose {
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
        System.out.println("Matrix A Transpose");

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                System.out.print(transpose(A)[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] transpose(int[][] matrix) {

        int[][] transpose = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

}

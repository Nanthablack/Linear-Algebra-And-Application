import java.util.*;

public class LinearEquations {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.println(".________________________.");
        System.out.println("|                        |");
        System.out.println("| LinearEquations ! AX=B |");
        System.out.println("|________________________|");

        System.out.println();
        System.out.println("Matrix A");
        System.out.print("[n x n]  n = ");

        int RC = scan.nextInt(); // RC = Row and Column
        System.out.println();

        int A[][] = new int[RC][RC];

        // Input Metrix A
        System.out.println("Matrix A");
        System.out.println("A[row][column]");
        System.out.println("[" + RC + " x " + RC + "]");
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
        float[][] AA = new float[RC][RC];

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                Adj[i][j] = Cofactors(i, j, A);
            }
        }
        if (Det(A) == 0) {

            System.out.println("Inverse Matrix\n");
            System.out.println("Empty!\n");

        } else {

            System.out.println("Matrix A Inverse ");

            for (int i = 0; i < RC; i++) {
                for (int j = 0; j < RC; j++) {
                    AA[i][j] = Adj[j][i] / Det(A);
                    System.out.printf("%.2f\t", (Adj[j][i] / Det(A)));
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Matrix B");
        System.out.println("B[row][column]");
        System.out.println("[" + RC + " x 1]");
        System.out.println();

        float[][] B = new float[RC][1];

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print("B[" + (i + 1) + "][" + (j + 1) + "]  = ");
                B[i][j] = scan.nextInt();
            }
        }
        System.out.println();

        // Output Metrix B
        System.out.println("Matrix B");

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.printf("%.2f\t", B[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        float[][] AB = new float[RC][1];
        AB[0][0] = 0;
        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < RC; k++) {
                    AB[i][j] = AB[i][j] + AA[i][k] * B[k][j];
                }
            }
        }

        // Output Metrix AB

        System.out.println("Matrix X (Matrix X = Matrix A inverse x Matrix B)");
        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print("X" + (i + 1) + " = " + AB[i][j]);
            }
            System.out.println();
        }

        System.out.println();

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
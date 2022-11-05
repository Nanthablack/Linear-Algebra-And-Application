import java.util.*;

public class Mutiplication {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println();

        System.out.println("Matrix A");
        System.out.print("row/column Matrix A : ");
        int rowA = scan.nextInt();
        int columnA = rowA;
        int rowB = rowA;
        int columnB = 4;

        System.out.println();

        float A[][] = new float[rowA][columnA];
        float B[][] = new float[rowB][columnB];

        // Input Metrix A
        System.out.println("Matrix A");
        System.out.println("A[row][column]");
        System.out.println();

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnA; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]  = ");
                A[i][j] = scan.nextFloat();
            }
            System.out.println();
        }

        // Output Metrix A
        System.out.println();
        System.out.println("Matrix A");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnA; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        // Input Metrix B
        System.out.println("Matrix B");
        System.out.println("B[row][column]");
        System.out.println();

        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < columnB; j++) {
                System.out.print("B[" + (i + 1) + "][" + (j + 1) + "]  = ");
                B[i][j] = scan.nextFloat();
            }
            System.out.println();
        }

        // Output Metrix A
        System.out.println();
        System.out.println("Matrix A");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnA; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

        // Output Metrix B
        System.out.println();
        System.out.println("Metrix B");
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < columnB; j++) {
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }

        // =======================================================================

        float[][] AB = new float[rowA][columnB];
        if (columnA == rowB) {
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < columnB; j++) {
                    for (int k = 0; k < rowB; k++) {
                        AB[i][j] = AB[i][j] + A[i][k] * B[k][j];
                    }
                }
            }
        }

        // Output Metrix AB
        System.out.println();
        System.out.println("Matrix AB");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                System.out.print(AB[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class GaussianEliminationNEW {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.println("___________________________");
        System.out.println("|                         |");
        System.out.println("|   [A][X] = [B]          |");
        System.out.println("|   Gaussion ELimination  |");
        System.out.println("|_________________________|");
        System.out.println();

        System.out.println("Matrix A");
        System.out.print("[n x n]  n = ");

        int RC = scan.nextInt();

        double[] B = new double[RC];
        double[][] A = new double[RC][RC];

        System.out.println();

        for (int i = 0; i < RC; i++) {
            for (int j = 0; j < RC; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "] = ");
                A[i][j] = scan.nextDouble();
            }
            System.out.println();
            System.out.print("B[" + (i + 1) + "] = ");
            B[i] = scan.nextDouble();
            System.out.println("_____________________________");
            System.out.println();

        }

        System.out.println();

        int N = B.length;

        for (int k = 0; k < N; k++) {

            for (int i = k + 1; i < N; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++)
                    A[i][j] -= factor * A[k][j];
            }
        }

        double[] Ans = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * Ans[j];
            Ans[i] = (B[i] - sum) / A[i][i];
        }

        System.out.println();
        System.out.println("Gaussian Elimination Matrix A (" + A.length + "x" + A.length + ") : ");
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%.3f\t ", A[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Gaussian Elimination Matrix B (" + B.length + "x1) : ");
        System.out.println();
        for (int i = 0; i < B.length; i++) {
            System.out.printf(" B[" + (i + 1) + "] = %.3f\n", B[i]);
        }

        System.out.println("\nSolution Matrix X : ");
        System.out.println();
        for (int i = 0; i < N; i++)
            System.out.printf(" X[" + (i + 1) + "] = %.3f\n", Ans[i]);
        System.out.println();

    }

}

import java.util.*;

class MetrixABandTranspose {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        try {

            System.out.println();

            System.out.println("Matrix A");
            System.out.print("row Matrix A : ");
            int rowA = scan.nextInt();
            System.out.print("column Matrix A : ");
            int columnA = scan.nextInt();

            System.out.println();

            System.out.println("Matrix B");
            System.out.print("row Matrix B : ");
            int rowB = scan.nextInt();
            System.out.print("column Matrix B : ");
            int columnB = scan.nextInt();

            System.out.println();

            int A[][] = new int[rowA][columnA];
            int B[][] = new int[rowB][columnB];

            // Input Metrix A
            System.out.println("Matrix A");
            System.out.println("A[row][column]");
            System.out.println();

            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < columnA; j++) {
                    System.out.print("A[" + (i + 1) + "][" + (j + 1) + "]  = ");
                    A[i][j] = scan.nextInt();
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
                    B[i][j] = scan.nextInt();
                }
                System.out.println();
            }

            // Output Metrix B
            System.out.println();
            System.out.println("Matrix B");
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < columnB; j++) {
                    System.out.print(B[i][j] + "\t");
                }
                System.out.println();
            }

            // =======================================================================

            int[][] AB = new int[rowA][columnB];
            if (columnA == rowB) {
                for (int i = 0; i < rowA; i++) {
                    for (int j = 0; j < columnB; j++) {
                        for (int k = 0; k < rowB; k++) {
                            AB[i][j] = AB[i][j] + A[i][k] * B[k][j];
                        }
                    }
                }
            }

            int[][] BA = new int[rowB][columnA];
            if (columnB == rowA) {
                for (int i = 0; i < rowB; i++) {
                    for (int j = 0; j < columnA; j++) {
                        for (int k = 0; k < rowA; k++) {
                            BA[i][j] = BA[i][j] + B[i][k] * A[k][j];
                        }
                    }
                }
            }

            int[][] ATB = new int[columnA][columnB];
            if (rowA == rowB) {
                for (int i = 0; i < columnA; i++) {
                    for (int j = 0; j < columnB; j++) {
                        for (int k = 0; k < rowB; k++) {
                            ATB[i][j] = ATB[i][j] + A[k][i] * B[k][j];
                        }
                    }
                }
            }

            int[][] BTA = new int[columnB][columnA];
            if (rowB == rowA) {
                for (int i = 0; i < columnB; i++) {
                    for (int j = 0; j < columnA; j++) {
                        for (int k = 0; k < rowA; k++) {
                            BTA[i][j] = BTA[i][j] + B[k][i] * A[k][j];
                        }
                    }
                }
            }

            int[][] ABT = new int[rowA][rowB];
            if (columnA == columnB) {
                for (int i = 0; i < rowA; i++) {
                    for (int j = 0; j < rowB; j++) {
                        for (int k = 0; k < columnB; k++) {
                            ABT[i][j] = ABT[i][j] + A[i][k] * B[j][k];
                        }
                    }
                }
            }

            int[][] BAT = new int[rowB][rowA];
            if (columnB == columnA) {
                for (int i = 0; i < rowB; i++) {
                    for (int j = 0; j < rowA; j++) {
                        for (int k = 0; k < columnA; k++) {
                            BAT[i][j] = BAT[i][j] + B[i][k] * A[j][k];
                        }
                    }
                }
            }

            int[][] ATBT = new int[columnA][rowB];
            if (rowA == columnB) {
                for (int i = 0; i < columnA; i++) {
                    for (int j = 0; j < rowB; j++) {
                        for (int k = 0; k < columnB; k++) {
                            ATBT[i][j] = ATBT[i][j] + A[k][i] * B[j][k];
                        }
                    }
                }
            }

            int[][] BTAT = new int[columnB][rowA];
            if (rowB == columnA) {
                for (int i = 0; i < columnB; i++) {
                    for (int j = 0; j < rowA; j++) {
                        for (int k = 0; k < columnA; k++) {
                            BTAT[i][j] = BTAT[i][j] + B[k][i] * A[j][k];
                        }
                    }
                }
            }

            // =======================================================================

            System.out.println(
                    "________________________________________________________________________________________");

            // Output Metrix A
            System.out.println();
            System.out.println("Matrix A");
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < columnA; j++) {
                    System.out.print(A[i][j] + "\t");
                }
                System.out.println();
            }
            // Metrix Transpose
            // Output Metrix A Transpose
            System.out.println();
            System.out.println("Matrix A Transpose");
            for (int i = 0; i < columnA; i++) {
                for (int j = 0; j < rowA; j++) {
                    System.out.print(A[j][i] + "\t");
                }
                System.out.println();
            }

            // Output Metrix B
            System.out.println();
            System.out.println("Matrix B");
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < columnB; j++) {
                    System.out.print(B[i][j] + "\t");
                }
                System.out.println();
            }
            // Metrix Transpose
            // Output Metrix B Transpose
            System.out.println();
            System.out.println("Matrix B Transpose");
            for (int i = 0; i < columnB; i++) {
                for (int j = 0; j < rowB; j++) {
                    System.out.print(B[j][i] + "\t");
                }
                System.out.println();
            }

            System.out.println(
                    "________________________________________________________________________________________");
            System.out.println();
            System.out.println(
                    "ค่าตัวเลือกในการแสดงผล(1-8) การคูณ Matirx A,B และ การTranspose \n\n ป้อนค่า 1 แสดง Matrix A คูณ Matrix B \n ป้อนค่า 2 แสดง Matrix B คูณ Matrix A \n ป้อนค่า 3 แสดง Matrix A ที่ Transpose คูณ Matrix B \n ป้อนค่า 4 แสดง Matrix B ที่ Transpose คูณ Matrix A \n ป้อนค่า 5 แสดง Matrix A คูณ Matrix B ที่ Transpose \n ป้อนค่า 6 แสดง Matrix B คูณ Matrix A ที่ Transpose \n ป้อนค่า 7 แสดง Matrix A ที่ Transpose คูณ Matrix B ที่ Transpose \n ป้อนค่า 8 แสดง Matrix B ที่ Transpose คูณ Matrix A ที่ Transpose\n\n ป้อนค่า 0 เพื่อจบการทำงานของโปรแกรม");
            System.out.println(
                    "________________________________________________________________________________________");
            Boolean Matrix = true;
            while (Matrix) {
                System.out.print("\nป้อนค่าตัวเลขรูปแบบผลลัพธ์ที่ท่านต้องการ : ");
                int number = scan.nextInt();
                switch (number) {
                    case 0:
                        System.out.println();
                        System.out.println("จบการทำงานโปรแกรม");
                        Matrix = false;
                        break;
                    case 1:
                        System.out.println();
                        System.out.println("[ Matrix AB ]");
                        if (columnA != rowB) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถหาค่าได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < rowA; i++) {
                                for (int j = 0; j < columnB; j++) {
                                    System.out.print(AB[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("[ Matrix BA ]");
                        if (columnB != rowA) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < rowB; i++) {
                                for (int j = 0; j < columnA; j++) {
                                    System.out.print(BA[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("[ Matrix ATB ]");
                        if (rowA != rowB) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < columnA; i++) {
                                for (int j = 0; j < columnB; j++) {
                                    System.out.print(ATB[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("[ Matrix BTA ]");
                        if (rowB != rowA) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < columnB; i++) {
                                for (int j = 0; j < columnA; j++) {
                                    System.out.print(BTA[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("[ Matrix ABT ]");
                        if (columnA != columnB) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < rowA; i++) {
                                for (int j = 0; j < rowB; j++) {
                                    System.out.print(ABT[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("[ Matrix BAT ]");
                        if (columnB != columnA) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < rowB; i++) {
                                for (int j = 0; j < rowA; j++) {
                                    System.out.print(BAT[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("[ Matrix ATBT and (BA)T ]");
                        if (rowA != columnB) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < columnA; i++) {
                                for (int j = 0; j < rowB; j++) {
                                    System.out.print(ATBT[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 8:
                        System.out.println();
                        System.out.println("[ Matrix BTAT and (AB)T ]");
                        if (rowB != columnA) {
                            System.out.println();
                            System.out.print("(X)ไม่สามารถคำนวณได้ เพราะ แถวและหลักที่ไม่เท่ากัน");
                            System.out.println();
                        } else {
                            for (int i = 0; i < columnB; i++) {
                                for (int j = 0; j < rowA; j++) {
                                    System.out.print(BTAT[i][j] + "\t");
                                }
                                System.out.println();
                            }
                        }
                        break;
                    default:
                        System.out.println();
                        System.out.println("# คุณป้อนข้อมูลไม่ถูกต้อง !!");
                }
            }

            System.out.println(
                    "________________________________________________________________________________________");
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println(" '(X) โปรแกรมนี้รับค่าเป็นตัวเลขเท่านั้น ' ");
            System.out.println();
        }
    }
}

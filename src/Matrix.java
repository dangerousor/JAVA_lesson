import java.util.Scanner;

import static java.lang.System.out;
//import java.util.Random;

public class Matrix {

    public static void main(String[] args) {
        out.println("Please input a int :");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int[][] result = produceMatrix(number);
        printDoubleMatrix(result);
    }

    //    method to produce a matrix; given int n, produce int n*n matrix
    private static int[][] produceMatrix(int dimen) {
        int[][] result = new int[dimen][dimen];
        if (dimen <= 0) {
            assert (false);
        } else {
            for (int i = 0; i != dimen; i++) {
                result[i][i] = 1;
            }
            printDoubleMatrix(result);
            if (1 == dimen)
                return result;
        }
        for (int i = 0; i != dimen; i++) {
            int[] temp = new int[dimen];
            for (int j = 0; j != dimen; j++) {
                if (i != j) {
                    temp = addArrayRandom(temp, result[j]);
                }
            }
            result[i] = addArrayRandom(result[i], temp);
        }
        return result;
    }

    private static int[] addArrayRandom(int[] array1, int[] array2) {
//        Random random = new Random();
        int flag = -1;
        for (int i = 0; i != array1.length; i++) {
            int temp = (int) (Math.random() * 10) + 1;
            out.println(temp);
            array1[i] += flag * temp * array2[i];
            flag *= -1;
        }
        return array1;
    }

    private static void printDoubleMatrix(int[][] matrix) {
        for (int[] temp : matrix) {
            for (int each : temp) {
                out.print(each + "\t");
            }
            out.println("");
        }
    }
}

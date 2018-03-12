import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("请输入维数：");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        out.println("1.左上\t2.左下\t3.右上\t4.右下\t");
        int pos = scan.nextInt();
        scan.close();
        int result[][] = new int[number][number];
        result = make_matrix(number, pos);
        for(int i=0; i!=result.length; i++) {
            for (int j = 0; j != result[i].length; j++) {
                out.print(result[i][j] + "\t");
            }
            out.print("\n");
        }
    }

    private static int[][] make_matrix(int n, int position) {
        int result[][];
        result = new int[n][n];
        int status = 0;
        int i, j;
        i = j =0;
        switch(position){
            case 1:
                result[0][0] = 1;
                i = j =0;
                status = 0;
                break;
            case 2:
                result[n-1][0] = 1;
                i = n-1;
                j = 0;
                status = 3;
                break;
            case 3:
                result[0][n-1] = 1;
                i = 0;
                j = n-1;
                status = 1;
                break;
            case 4:
                result[n-1][n-1] = 1;
                i = j = n-1;
                status = 2;
                break;
            default:
                break;
        }
        if (n == 1) {
            return result;
        }
        int counter = 1;
        fill_loop:
        while (true) {
            switch (status) {
                case 0:
                    j = j + 1;
                    if (counter == n*n)
                        break fill_loop;
                    result[i][j] = result[i][j - 1] + 1;
                    counter++;
                    if ((j == n - 1)||(result[i][j+1] != 0)) {
                        status = 1;
                    } else {
                        break;
                    }
                    break;
                case 1:
                    i++;
                    if (counter == n*n)
                        break fill_loop;
                    result[i][j] = result[i - 1][j] + 1;
                    counter++;
                    if ((i == n - 1)||(result[i+1][j] != 0)) {
                        status = 2;
                    } else {
                        break;
                    }
                    break;
                case 2:
                    j--;
                    if (counter == n*n)
                        break fill_loop;
                    result[i][j] = result[i][j + 1] + 1;
                    counter++;
                    if ((j == 0)||(result[i][j-1] != 0)) {
                        status = 3;
                    } else
                        break;
                    break;
                case 3:
                    i--;
                    if (counter == n*n)
                        break fill_loop;
                    result[i][j] = result[i + 1][j] + 1;
                    counter++;
                    if ((i == 0)||(result[i-1][j] != 0)) {
                        status = 0;
                    } else
                        break;
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}

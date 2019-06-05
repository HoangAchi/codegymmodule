package SumNumberColumn;
import java.util.Scanner;
public class SumNumberColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the column number of the array ");
        int col = scanner.nextInt();
        System.out.println("Enter the line number of the array");
        int lin = scanner.nextInt();
        int arr[][] = new int[col][lin];
        System.out.println(" Enter elements for the array: ");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < lin; j++) {
                System.out.print(" A[" + i + "]["+ j + "] = ");
                arr[i][j] = scanner.nextInt();
            }
        }
        int max = arr[0][0];
        for (int j=0;j<col;j++){
            max += arr[0][j];
        }
        System.out.println(max);
    }
}

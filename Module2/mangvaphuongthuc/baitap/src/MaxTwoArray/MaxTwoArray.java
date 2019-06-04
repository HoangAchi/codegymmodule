package MaxTwoArray;
import java.util.Scanner;
public class MaxTwoArray {
    public static void main(String[] args) {
        int lin, col;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line number of the array ");
        lin = scanner.nextInt();
        System.out.println("Enter the column number of the array ");
        col = scanner.nextInt();
        int arr[][] = new int[lin][col];

        System.out.println("Enter elements for the array: ");
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("A[" + i + "]["+ j + "] = ");
                arr[i][j] = scanner.nextInt();
            }
        }
        int max = arr[0][0];
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        System.out.println("max array = " + max);
    }
}

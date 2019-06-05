package SumSquareMatrix;
import java.util.Scanner;
public class SumSquareMatrix {
    public static void main(String[] args) {
        int rank;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the order of the matrix: ");
        rank = scanner.nextInt();

        int arr[][] = new int[rank][rank];

        System.out.println("Input elements for the matrix: ");
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                System.out.print("A[" + i + "]["+ j + "] = ");
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Array A output:");
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }

        // các phần tử nằm trên đường chéo chính
        // là các phần tử có chỉ số dòng = chỉ số cột
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                // kiểm tra nếu i == j thì mới tính tổng
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("Total elements are located on the main diagonal = " + sum);
    }
}

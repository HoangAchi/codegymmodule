package CombineArray;
import java.util.Scanner;
public class CombineArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input the element number of the array 1:");
        int input = scanner.nextInt();
        int[] arr1 = new int[input];
        System.out.println("input the elements of the array 1");
        for (int i = 0 ; i<input;i++){
            System.out.println("Enter element" + i);
            arr1[i] = scanner.nextInt();
        }
        System.out.println("input the element number of the array 2:");
        int input1 = scanner.nextInt();
        int[] arr2 = new int[input1];

        System.out.println("input the elements of the array 2");
        for (int j = 0 ; j<input1;j++){
            System.out.println("Enter element" + j);
            arr2[j] = scanner.nextInt();
        }

        int size = arr1.length + arr2.length;
        int[] array = new int[size];
        System.out.println("Array 1:");
        for (int item : arr1) {
            System.out.print(item + "\t");
        }

        System.out.println();
        System.out.println("Array 2:");
        for (int item : arr2) {
            System.out.print(item + "\t");
        }

        System.arraycopy(arr1, 0, array, 0, arr1.length);
        System.arraycopy(arr2, 0, array, arr2.length, size - arr2.length);
        System.out.println();
        System.out.println("Array = Array 1 + Array 2:");
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}

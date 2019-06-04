package CombineArray;
import java.util.Scanner;
public class CombineArray {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr1 = null;
        int[] arr2 = null;
        int[] arr3 = null;

        System.out.println("input array first ");
        arr1 = input(arr1);
        System.out.println("input array secondary ");
        arr2 = input(arr2);
        arr3 = merge(arr1, arr2);
        show(arr3);
    }

    public static int[] input(int[] arr) {
        System.out.print("Enter the element number of the array: ");
        int inputarr = scanner.nextInt();
        arr = new int[inputarr];
        System.out.print("Enter the elements of the array: \n");
        for (int i = 0; i < inputarr; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int aIndex = arr1.length - 1;
        int bIndex = arr2.length - 1;
        int cIndex = arr1.length + arr2.length - 1;
        int[] arr3 = new int[cIndex + 1];


        for (int i = cIndex; i > -1; i--) {
            if (aIndex > -1 && bIndex > -1) {
                if (arr1[aIndex] > arr2[bIndex]) {
                    arr3[i] = arr1[aIndex--];
                } else {
                    arr3[i] = arr2[bIndex--];
                }
            } else if (bIndex == -1) {
                arr3[i] = arr1[aIndex--];
            } else if (aIndex == -1) {
                arr3[i] = arr2[bIndex--];
            }
        }
        return arr3;
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

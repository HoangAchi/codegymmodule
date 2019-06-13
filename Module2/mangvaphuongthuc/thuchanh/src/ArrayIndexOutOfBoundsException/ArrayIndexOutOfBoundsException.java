package ArrayIndexOutOfBoundsException;
import java.util.Random;
import java.util.Scanner;
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        ArrayIndexOutOfBoundsException arrExample = new ArrayIndexOutOfBoundsException();
        Integer[] arr = arrExample.createRandom();

        Scanner scaner = new Scanner(System.in);
        System.out.println("\n" + "Please enter the index of any element: ");
        int x = scaner.nextInt();
        try {
            System.out.println("Value of the index element " + x + " was " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\n" + "The index exceeds the limit of the array");
        }
    }
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List element of array: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
}

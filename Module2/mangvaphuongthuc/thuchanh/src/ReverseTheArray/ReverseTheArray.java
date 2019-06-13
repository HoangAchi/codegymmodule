package ReverseTheArray;
import java.util.Scanner;
public class ReverseTheArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);

        size = getSize(scanner);
        array = new int[size];

        setLocationArray(array, scanner);
        System.out.printf("%-20s%s", "Elements in array: ", "");

        reverse(size, array);
    }

    private static void reverse(int size, int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }

    private static void setLocationArray(int[] array, Scanner scanner) {
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
    }

    private static int getSize(Scanner scanner) {
        int size;
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        return size;
    }
}

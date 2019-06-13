package MaxArray;
import java.util.Scanner;
public class MaxArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);

        size = getSize(scanner);
        array = new int[size];

        setLocationArray(array, scanner);

        System.out.print("Property list: ");
        listArray(array);

        getMax(array);
    }

    private static void getMax(int[] array) {
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }

    private static void listArray(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }

    private static void setLocationArray(int[] array, Scanner scanner) {
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
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
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        return size;
    }
}

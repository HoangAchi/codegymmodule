package CountsStudentpassingTheExam;
import java.util.Scanner;
public class CountsStudentpassingTheExam {
    public static void main(String[] args) {
        int size;
        int[] array;

        Scanner scanner = new Scanner(System.in);
        size = getSize(scanner);
        array = new int[size];

        setLocationArray(array, scanner);

        checkStudentPassTheExam(array);
    }

    private static void checkStudentPassTheExam(int[] array) {
        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }

    private static void setLocationArray(int[] array, Scanner scanner) {
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
    }

    private static int getSize(Scanner scanner) {
        int size;
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
        return size;
    }
}

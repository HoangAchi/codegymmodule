package CountString;
import java.util.Scanner;
public class CountString {
    public static void main(String[] args) {
        String onestring;
        char signself;
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input any string: ");
        onestring = scanner.nextLine();
        System.out.println("Input any char: ");
        signself = scanner.next().charAt(0);

        for (int i = 0; i < onestring.length(); i++) {
            if (onestring.charAt(i) == signself) {
                count++;
            }
        }
        System.out.println("Number of occurrences of signself " + signself +
                " in string " + onestring + " = " + count);
    }
}

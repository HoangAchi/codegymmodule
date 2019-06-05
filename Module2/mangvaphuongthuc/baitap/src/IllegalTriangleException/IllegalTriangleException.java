package IllegalTriangleException;
import java.util.Scanner;
public class IllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Three Double Side: ");
        int edge1 = scanner.nextInt();
        int edge2 = scanner.nextInt();
        int edge3 = scanner.nextInt();
        try {
            int result = Triangle(edge1, edge2, edge3);
            System.out.println("Valid triangle sides");
        } catch (Exception e) {
            System.out.println("Exception: Invalid Triangle Side Numbers");
        }
    }
    public static int Triangle(int edge1, int edge2, int edge3) {

        if (edge1 <= 0 || (edge1 + edge2) < edge3 || (edge1 + edge3) < edge2) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else if (edge2 <= 0 || (edge2 + edge3) < edge1) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else if (edge2 <= 0) {
            throw new IllegalArgumentException("Invalid Triangle Side Numbers");
        } else {
            throw new IllegalArgumentException("Valid Triangle Side Numbers");
        }
    }
}

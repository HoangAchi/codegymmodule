package ShowShape;
import java.util.Scanner;
public class ShowShape {
    public static final int CONSTANT_RECTANGLE = 1;
    public static final int CONSTANT_SQUARE_TRIANGLE = 2;
    public static final int CONSTANT_ISOSCELES_TRIANGLE = 3;
    public static final int CONSTANT_EXIT = 4;

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        switch (choice){
            case CONSTANT_RECTANGLE:
                for (int i =0; i<3;i++){
                    for (int j=0;j<5;j++){

                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case CONSTANT_SQUARE_TRIANGLE:
                for (int i =0; i<5;i++){
                    for (int j=0;j<i+1;j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case CONSTANT_ISOSCELES_TRIANGLE:
                for (int i =6; i>0;i--){
                    for (int j=0;j<i-1;j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case CONSTANT_EXIT:
                System.exit(4);
            default:
                System.out.println("No choice!");
        }
    }
}

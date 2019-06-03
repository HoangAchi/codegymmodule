package ShowShape;
import java.util.Scanner;
public class ShowShape {
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
            case 1:
                for (int i =0; i<3;i++){
                    for (int j=0;j<5;j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case 2:
                for (int i =0; i<5;i++){
                    for (int j=0;j<i+1;j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case 3:
                for (int i =6; i>0;i--){
                    for (int j=0;j<i-1;j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case 4:
                System.exit(4);
            default:
                System.out.println("No choice!");
        }
    }
}

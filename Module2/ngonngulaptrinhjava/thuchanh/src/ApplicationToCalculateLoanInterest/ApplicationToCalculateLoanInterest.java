package ApplicationToCalculateLoanInterest;
import java.util.Scanner;
public class ApplicationToCalculateLoanInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money = input.nextDouble();
        System.out.println("Enter number of months: ");
        int month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        double intersetRate = input.nextDouble();
        double totalInterset = 0;
        loanInterestCalculator(money, month, intersetRate, totalInterset);
    }

    private static void loanInterestCalculator(double money, int month, double intersetRate, double totalInterset) {
        for(int i = 0; i < month; i++){
            totalInterset = money * (intersetRate/100)/12 * 3;
        }
        System.out.println("Total of interset: " + totalInterset);
    }
}

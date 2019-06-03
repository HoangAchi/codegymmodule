package Show20PrimeNumbersFirst;
import java.util.Scanner;
public class Show20PrimeNumbersFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        int count = 0;
        int N =2;
        while (count<number) {
            if (isPrimeNumber(N)){
                System.out.println(N + " ");
                count++;
            }
            N++;
        }
    }
    public static boolean isPrimeNumber(int number){
        if (number<2){
            return false;
        }
        for (int i =2;i<Math.sqrt(number);i++){
            if (number % i == 0){
                return false;
            }
        }
        return  true;
    }
}

package CurrencyConversionApplication;
import java.util.Scanner;
public class CurrencyConversionApplication {
    public static void main(String[] args) {
        double vnd = 23000;
        Scanner convert = new Scanner(System.in);
        System.out.println("Enter USD TO VND");
        double usd = convert.nextInt();
        double count = vnd*usd;
        System.out.println(count);
    }
}

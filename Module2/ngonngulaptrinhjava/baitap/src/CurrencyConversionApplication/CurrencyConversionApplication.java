package CurrencyConversionApplication;
import java.util.Scanner;
public class CurrencyConversionApplication {
    public static void main(String[] args) {
        Scanner convert = new Scanner(System.in);
        System.out.println("Enter USD TO VND");
        caculateVND(convert);
    }

    private static void caculateVND(Scanner convert) {
        double vnd = 23000;
        double usd = convert.nextInt();
        double count = vnd*usd;
        System.out.println(count);
    }
}

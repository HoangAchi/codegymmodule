package CalculateBodyWeight;
import java.util.Scanner;
public class CalculateBodyWeight {
    public static final String STRING_SHOWS="%-20s%s";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("Your weight (in kilogram):");
        weight = scanner.nextDouble();

        System.out.print("Your height (in meter):");
        height = scanner.nextDouble();
        bmi = getBmi(weight, height);

        checkBMI(bmi);
    }

    private static double getBmi(double weight, double height) {
        double bmi;
        bmi = weight / Math.pow(height, 2);
        System.out.printf(STRING_SHOWS, "bmi", "Interpretation\n");
        return bmi;
    }

    private static void checkBMI(double bmi) {
        if (bmi < 18)
            System.out.printf(STRING_SHOWS, bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf(STRING_SHOWS, bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf(STRING_SHOWS, bmi, "Overweight");
        else
            System.out.printf(STRING_SHOWS, bmi, "Obese");
    }
}

package ReadNumbersIntoLetter;

import java.util.Scanner;
public class ReadNumbersIntoLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number you need to read");
        int number = scanner.nextInt();
        if (number < 10 && number >= 0){
            switch (number){
                case 9:
                    System.out.println("nine");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 5:
                    System.out.println("fine");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                default:
                    System.out.println("zero");
                    break;
            }
        }
        else if (number <20) {
            switch (number){
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thirteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eighteen");
                    break;
                default:
                    System.out.println("nineteen");
                    break;
            }
        }
        else if (number<100){
            String temp = "";
            int dozens = number/10;
            int unit = number%10;
            switch (dozens){
                case 9:
                    temp += "ninety ";
                    break;
                case 8:
                    temp += "eighty ";
                    break;
                case 7:
                    temp += "seventy ";
                    break;
                case 6:
                    temp += "sixty ";
                    break;
                case 5:
                    temp += "fifty ";
                    break;
                case 4:
                    temp += "forty ";
                    break;
                case 3:
                    temp += "thirty ";
                    break;
                default:
                    temp += "twenty ";
                    break;
            }
            switch (unit) {
                case 9:
                    temp += "nine";
                    break;
                case 8:
                    temp += "eight";
                    break;
                case 7:
                    temp += "seven";
                    break;
                case 6:
                    temp += "six";
                    break;
                case 5:
                    temp += "fine";
                    break;
                case 4:
                    temp += "four";
                    break;
                case 3:
                    temp += "three";
                    break;
                case 2:
                    temp += "two";
                    break;
                case 1:
                    temp += "one";
                    break;
                default:
                    temp += "zero";
                    break;
            }
            System.out.println(temp);
        }
        else if (number<1000){
            String result = "";
            int hundred = number/100;
            int tens = (number%100)/10;
            int ones = number%10;
            switch (hundred){
                case 9:
                    result += "nine hundred ";
                    break;
                case 8:
                    result += "eight hundred ";
                    break;
                case 7:
                    result += "seven hundred ";
                    break;
                case 6:
                    result += "six hundred ";
                    break;
                case 5:
                    result += "fine hundred ";
                    break;
                case 4:
                    result += "four hundred ";
                    break;
                case 3:
                    result += "three hundred ";
                    break;
                case 2:
                    result += "two hundred ";
                    break;
                default:
                    result += "one hundred ";
                    break;
            }
            switch (tens){
                case 9:
                    result += "ninety";
                    break;
                case 8:
                    result += "eighty";
                    break;
                case 7:
                    result += "seventy";
                    break;
                case 6:
                    result += "sixty";
                    break;
                case 5:
                    result += "fifty";
                    break;
                case 4:
                    result += "forty";
                    break;
                case 3:
                    result += "thirty";
                    break;
                default:
                    result += "twenty";
                    break;
            }
            switch (ones) {
                case 9:
                    result += " nine";
                    break;
                case 8:
                    result += " eight";
                    break;
                case 7:
                    result += " seven";
                    break;
                case 6:
                    result += " six";
                    break;
                case 5:
                    result += " fine";
                    break;
                case 4:
                    result += " four";
                    break;
                case 3:
                    result += " three";
                    break;
                case 2:
                    result += " two";
                    break;
                case 1:
                    result += " one";
                    break;
                default:
                    result += " zero";
                    break;
            }
            System.out.println(result);
        }
        else {
            System.out.println("out of ability");
        }
    }
}

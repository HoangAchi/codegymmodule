package ClassQuadraticEquation;
import java.util.Scanner;
public class ClassQuadraticEquation {
    private double a,b,c;
    public ClassQuadraticEquation(){
    }
    public ClassQuadraticEquation(double a,double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return Math.pow(b,2) - 4*a*c;
    }
    public double getRoot1(){
        if (getDiscriminant() <0){
            return 0;
        } else if (getDiscriminant()== 0){
            return -b / (2*a);
        } else {
            return (-b + Math.sqrt(getDiscriminant()))/(2*a);
        }
    }
    public double getRoot2(){
        if (getDiscriminant() <0){
            return 0;
        } else if (getDiscriminant()== 0){
            return -b / (2*a);
        } else {
            return (-b - Math.sqrt(getDiscriminant()))/(2*a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a = ");
        int a = scanner.nextInt();
        System.out.println("Input b = ");
        int b = scanner.nextInt();
        System.out.println("Input c = ");
        int c = scanner.nextInt();
        ClassQuadraticEquation QuadraticEquation = new ClassQuadraticEquation(a,b,c);
        if (QuadraticEquation.getDiscriminant() < 0){
            System.out.println("the equation no solution");
        } else if (QuadraticEquation.getDiscriminant() == 0){
            System.out.println("the equation have two solution equal " + QuadraticEquation.getRoot1());
        } else if (QuadraticEquation.getDiscriminant() >0){
            System.out.println("the equation have two solution distinguish");
            System.out.println("x1= " + QuadraticEquation.getRoot1());
            System.out.println("x2= " + QuadraticEquation.getRoot2());
        }
    }
}

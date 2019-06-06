package Triangle;
import java.lang.String;
public class Triangle extends Shape {
    protected double side1 =1,side2 = 1,side3 = 1;
    public Triangle(){}
    public Triangle(String color, boolean filled,double side1, double side2, double side3){
        super(color,filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        return Math.sqrt((side1+side2+side3)*(side1+side2-side3)*(side2+side3-side1)*(side3+side1-side2))/4;
    }
    public double getPerimeter(){
        return 2*(side1+side2+side3/2);
    }

    @Override
    public String toString() {
        return super.toString()
                +" edge1 "
                +getSide1()
                +" edge2 "
                +getSide2()
                +" edge3 "
                +getSide3();
    }
}

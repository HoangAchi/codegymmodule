package Circle;

public class Circle {
    protected double radius;
    protected String color;

    protected Circle(){}
    public Circle(double radius, String color){
        this.radius =radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
    protected double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Radius "
                + getRadius()
                + " Color "
                + getColor();
    }
}

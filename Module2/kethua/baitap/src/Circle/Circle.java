package Circle;

public class Circle {
    private String color;
    private double radius;
    public Circle(){

    }
    public Circle(double radius,String color){
        this.color = color;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    @Override
    public String toString(){
        return "A Circle with radius = "
                + getRadius()
                + ", A Circle with color of "
                + getColor();
    }
}

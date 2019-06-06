package Circle;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){

    }
    public Cylinder(double height){
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double volume(){
        return 2*Math.PI*getRadius()*getHeight();
    }
    @Override
    public String toString(){
        return " A Cylinder "
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}

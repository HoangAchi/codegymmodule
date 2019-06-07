package circle;

public class Cylinder extends Circle {
    protected int height;
    public Cylinder(){}
    public Cylinder(double radius, String color ,int height){
        super(radius,color);
        this.height=height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    protected double getVolume(){
        return Math.PI * Math.pow(radius,2) * this.height;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Height"
                +this.getHeight();
    }
}

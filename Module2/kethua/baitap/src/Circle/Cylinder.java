package Circle;

public class Cylinder extends Circle {
    protected int Height;
    public Cylinder(){}
    public Cylinder(double radius, String color ,int Height){
        super(radius,color);
        this.Height=Height;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
    protected double getVolume(){
        return Math.PI * Math.pow(radius,2) * Height;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Height"
                +getHeight();
    }
}

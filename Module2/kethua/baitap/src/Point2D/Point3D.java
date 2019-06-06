package Point2D;

public class Point3D extends Point2D {
    private float z;
    public  Point3D(){}
    public  Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
       setXY(x, y);
       this.z = z;
    }
    float[] arr1 = new float[3];
    public float[] getXYZ(){
        arr1[0] = getX();
        arr1[1] = getY();
        arr1[2] = this.z;
        return arr1;
    }
    public String arr1(){
        String string = " " + arr1[0] + " " +arr1[1] + " " + arr1[2];
        return string;
    }
    @Override
    public String toString(){
        return  " "
                + arr1();
    }
}

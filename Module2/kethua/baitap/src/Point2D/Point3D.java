package Point2D;

public class Point3D extends Point2D {
    protected float z;
    protected Point3D(){ }
    protected Point3D(float x, float y , float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    float[] arr= new float[3];
    public float[] getXYZ(){
        arr[0] = this.x;
        arr[1] = this.y;
        arr[2] = this.z;
        return arr;
    }
    public String browseTheArray(){
        getXYZ();
        String str = "";
        for (int i=0;i<arr.length;i++){
            str += arr[i]+" ";
        }
        return  str;
    }

    @Override
    public String toString() {
        return "coordinates X And Y And Z "
                + browseTheArray();
    }
}

package point2D;

public class Point2D {
    protected float x;
    protected float y;
    protected Point2D(){ }

    protected Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    float[] arr = new float[2];
    public float[] getXY(){
        arr[0] = this.x;
        arr[1] = this.y;
        return arr;
    }

    public String browseTheArray(){
        getXY();
        String str = "";
        for (int i=0;i<arr.length;i++){
            str += arr[i]+" ";
        }
        return  str;
    }
    @Override
    public String toString() {
        return " coordinates X And Y "
                + browseTheArray();
    }
}

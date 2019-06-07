package point;

public class Point {
    protected float x;
    protected float y;
    protected Point(){}
    protected Point(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
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
        return  arr;
    }

    @Override
    public String toString() {
        return " coordinates X "
                +getX()
                +" coordinates Y "
                +getY();
    }
}

package Point;

public class MoveablePoint extends Point {
    private float xspeed;
    private float yspeed;
    public MoveablePoint(){}
    public MoveablePoint(float x, float y, float xspeed, float yspeed){
        super(x, y);
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }
    public MoveablePoint(float xspeed, float yspeed){
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }

    public float getXspeed() {
        return xspeed;
    }

    public float getYspeed() {
        return yspeed;
    }

    public void setXspeed(float xspeed) {
        this.xspeed = xspeed;
    }

    public void setYspeed(float yspeed) {
        this.yspeed = yspeed;
    }
    public void setSpeed(float xspeed, float yspeed){
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }
    public float[] getSpeed(){
        float arr[] = new float[2];
        arr[0] = this.xspeed;
        arr[1] = this.yspeed;
        return arr;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Speed X "
                + getXspeed()
                + " Speed Y "
                + getYspeed();
    }
    public float[] move(){
        x += xspeed;
        y += yspeed;
        return getXY();
    }
}

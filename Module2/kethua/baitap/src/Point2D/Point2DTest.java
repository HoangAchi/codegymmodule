package Point2D;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(20,20);
        point2D.getXY();
        System.out.print(point2D);
    }
}

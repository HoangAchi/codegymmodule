package Point2D;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(3,5,7);
        point3D.getXYZ();
        System.out.println(point3D);
    }
}

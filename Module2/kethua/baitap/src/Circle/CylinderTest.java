package Circle;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5,"White", 7);
        System.out.println(cylinder);
        System.out.println("Volume " + cylinder.getVolume());
    }
}

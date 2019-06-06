package Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        triangle = new Triangle("Black",false,3,4,5);
        System.out.println(triangle);
        System.out.println(" Area " + triangle.getArea());
        System.out.println(" Perimeter " + triangle.getPerimeter());
    }
}

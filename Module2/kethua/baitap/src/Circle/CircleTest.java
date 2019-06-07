package Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(4,"Black");
        System.out.println(circle);
        System.out.println("Area Circle " + circle.getArea());
    }
}

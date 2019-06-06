package Circle;

public class CribleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5, "indigo");
        System.out.println(circle);
    }
}

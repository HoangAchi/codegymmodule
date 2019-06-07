package shape;
public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        System.out.println("before resizing ");
        for (Shape shape : shapes){
            if (shape instanceof Rectangle){
                Resizeable resizeable = (Rectangle) shape;
                resizeable.resize(Math.random()*100);
                System.out.println(resizeable);
            }
            if (shape instanceof Square){
                Resizeable resizeable = (Square) shape;
                resizeable.resize(Math.random()*100);
                System.out.println(resizeable);
            }
            if (shape instanceof Circle){
                Resizeable resizeable = (Circle) shape;
                resizeable.resize(Math.random()*100);
                System.out.println(resizeable);
            }
        }

    }
}

package Point;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(5,5);
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(5,5,10,10);
        System.out.println(moveablePoint);
    }
}

package point;

public class MobeablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(10,10,20,20);
        System.out.println(moveablePoint);
    }
}

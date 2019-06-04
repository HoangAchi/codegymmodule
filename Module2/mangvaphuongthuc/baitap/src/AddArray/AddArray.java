package AddArray;
import java.util.Scanner;
public class AddArray {
    public static void main(String[] args) {
        int []arr = {10,4,6,7,8,0,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index:");
        int index = scanner.nextInt();
        if (index <=1 && index>=arr.length-1){
            System.out.println("cannot insert element into array");
        }else {
            for (int i =arr.length-1;i>index;i--){
                arr[i] = arr[i-1];
            }
            System.out.print("Enter value:");
            int input_value = scanner.nextInt();
            arr[index] =  input_value;
            for (int j=0;j<arr.length;j++){
                System.out.println(arr[j]);
            }
        }
    }
}

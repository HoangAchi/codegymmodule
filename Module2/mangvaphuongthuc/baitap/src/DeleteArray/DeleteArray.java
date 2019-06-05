package DeleteArray;

import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int[] arr = new int[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("input the elements of the array");
        for (int i =0 ; i<arr.length-2;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("input the element to delete");
        int del = scanner.nextInt();
        int index =0;
        for (int j=0;j<arr.length;j++){
            if (arr[j] == del){
                index = j;
            }else {
                System.out.println(arr[j]);
            }
        }
        for (int i =index;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        for (int i = 0;i<arr.length-2;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}


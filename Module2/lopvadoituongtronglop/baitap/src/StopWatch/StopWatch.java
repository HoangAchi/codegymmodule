package StopWatch;

import java.util.Random;

public class StopWatch {
    private long starttime;
    private long endtime;

    public long getStartTime() {
        this.starttime = System.currentTimeMillis();
        return this.starttime;
    }

    public long getEndTime() {
        this.endtime = System.currentTimeMillis();
        return this.endtime;
    }
    public long getElapsedTime(){
        return (this.endtime-this.starttime);
    }
    public static void main(String[] args) {
        System.out.println("Measure the execution time of the sorting algorithm to choose 100,000 numbers from the given variable");
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        StopWatch watch = new StopWatch();
        watch.getStartTime();
        int  temp;
        for  ( int  i =  0 ; i <array.length -  1 ; i ++) {
            for  ( int  j =  0 ; j <array.length -  1  - i; j ++) {
                if  (array [j]> array [j +  1 ]) {
                    temp = array [j];
                    array [j] = array [j +  1 ];
                    array [j +  1 ] = temp;
                }
            }
        }
        watch.getEndTime();
        long timeWatch = watch.getElapsedTime();
        System.out.println("Thời gian thực thi là: "+timeWatch);
    }
}

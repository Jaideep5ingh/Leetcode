package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageFromDataStream346 {
    List<Integer> list;
    int start=0;
    int capacity;
    double sum=0.0;

    public MovingAverageFromDataStream346(int size) {
        this.list = new ArrayList<>(size);
        this.capacity = size;
    }

    public double next(int val) {
        if (list.size()>=this.capacity){
            sum-=list.get(start);
            list.remove(start);
        }
        this.list.add(val);
        sum+=val;
        return sum/this.list.size();
    }


    public static void main(String[] args) {
        MovingAverageFromDataStream346 movingAverage = new MovingAverageFromDataStream346(3);
        movingAverage.next(1); // return 1.0 = 1 / 1
        movingAverage.next(10); // return 5.5 = (1 + 10) / 2
        movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
    
}

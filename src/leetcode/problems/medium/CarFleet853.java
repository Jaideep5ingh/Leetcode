package leetcode.problems.medium;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet853 {
    public static void main(String[] args) {
        int[] position = {6,8};
        int[] speed = {3,2};

        Pair<Integer, Integer>[] cars = new Pair[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Pair<>(position[i], speed[i]);
        }

        Arrays.sort(cars, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.getKey()  - o1.getKey();
            }
        });

        int target = 10;
        Stack<Pair<Integer, Double>> stack = new Stack<>();

        for (Pair<Integer,Integer> car : cars){
            double distance = Double.valueOf(target - car.getKey());
            double carSpeed =  Double.valueOf(car.getValue());
            double time = distance/carSpeed;
            if(!stack.isEmpty()){
                double stackCarTime = stack.peek().getValue();
                if (time <= stackCarTime) continue;
            }
            stack.push(new Pair<>(car.getKey(), time));
        }
        System.out.println(stack.size());
    }
}

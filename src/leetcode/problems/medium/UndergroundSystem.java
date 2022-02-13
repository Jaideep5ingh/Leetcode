package leetcode.problems.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> customerTrips ;
    HashMap<String, ArrayList<Integer>> trips;

    public UndergroundSystem() {
        this.customerTrips = new HashMap<>();
        this.trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customerTrips.put(id, new Pair<>(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = customerTrips.get(id);
        String trip = pair.getKey() + "-" + stationName;
        ArrayList<Integer> list;
        if (trips.containsKey(trip)){
            list = trips.get(trip);
        }
        else {
            list = new ArrayList<>();
        }
        list.add(t-pair.getValue());
        trips.put(trip,list);

        customerTrips.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        ArrayList<Integer> list = trips.get(startStation+"-"+endStation);
        double totalTime= 0.0;
        for (int i : list){
            totalTime+=i;
        }
        return totalTime/list.size();
    }

    public static void main(String[] args) {
        UndergroundSystem obj = new UndergroundSystem();
        obj.checkIn(45,"Leyton",3);
        obj.checkOut(45,"Waterloo",15);
        obj.checkIn(30,"Leyton",4);
        obj.checkIn(40,"Leyton",5);
        obj.checkOut(30,"Waterloo",10);
        obj.checkOut(40,"Waterloo",12);
        System.out.println(obj.trips);
        double param_3 = obj.getAverageTime("Leyton","Waterloo");
        System.out.println(param_3);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
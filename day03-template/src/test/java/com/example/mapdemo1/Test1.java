package com.example.mapdemo1;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Map<Location, Integer> decisionMap = new HashMap<Location, Integer>();
        List<Location> votes = new ArrayList<Location>();
        int number = 80;
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int where = random.nextInt(4);
            votes.add(getLocation(where));
        }
        decisionMap.put(Location.A, 0);
        decisionMap.put(Location.B, 0);
        decisionMap.put(Location.C, 0);
        decisionMap.put(Location.D, 0);
        for (Location vote : votes) {
            switch (vote) {
                case A:
                    decisionMap.put(Location.A, decisionMap.get(Location.A) + 1);
                    break;
                case B:
                    decisionMap.put(Location.B, decisionMap.get(Location.B) + 1);
                    break;
                case C:
                    decisionMap.put(Location.C, decisionMap.get(Location.C) + 1);
                    break;
                case D:
                    decisionMap.put(Location.D, decisionMap.get(Location.D) + 1);
                    break;
                default:
                    break;
            }
        }
        decisionMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    public static Location getLocation(int number) {
        switch (number) {
            case 0:
                return Location.A;
            case 1:
                return Location.B;
            case 2:
                return Location.C;
            case 3:
                return Location.D;
            default:
                return null;
        }
    }

}

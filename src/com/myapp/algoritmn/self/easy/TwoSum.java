package com.myapp.algoritmn.self.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] input = {5, 10, 15, 20, 25, 30, 35};
        Map<Integer, Integer> map = new HashMap<>();
        int requiredSum = 66;

        for (int i = 0; i < input.length; i++) {
            int restSum = requiredSum - input[i];
            if (map.containsKey(restSum)) {
                System.out.println("sum " + requiredSum + " found at [" + map.get(restSum) + "," + i + "]");
                return;
            }
            map.put(input[i], i);
        }
        System.out.println("NA");


    }
}

package com.myapp.algoritmn.self.easy;

import java.lang.instrument.ClassDefinition;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private final String roman;
    private static final Map<String, Integer> ref = new HashMap<>();

    static {
        ref.put("V", 5);
        ref.put("X", 10);
        ref.put("L", 50);
        ref.put("C", 100);
        ref.put("D", 500);
        ref.put("M", 1000);
        ref.put("CD", 400);
        ref.put("CM", 900);
        ref.put("XL", 40);
        ref.put("XC", 90);
        ref.put("IV", 4);
        ref.put("IX", 9);
        ref.put("I", 1);
    }

    RomanToInteger(String i) {
        this.roman = i;
    }


    private int printInteger() {
        String r = roman;
        String previous = "";
        int sum = 0;
        for (int i = 0; i < r.length(); i++) {
            if (!ref.containsKey(r.charAt(i)+"")) {
                System.out.println("not a valid roman number");
                break;
            }
            if (!previous.equals("") && ref.containsKey(previous + r.charAt(i))) {
                sum = sum + ref.get(previous + r.charAt(i));
                sum = sum  - ref.get(previous);
            } else {
                sum = sum + ref.get(r.charAt(i)+"");
            }
            previous = r.charAt(i) + "";
        }
        return sum;
    }

    public static void main(String[] args) {
        String input = "MCMXCIV";
        RomanToInteger logic = new RomanToInteger(input);
        System.out.println(logic.printInteger());
    }

}

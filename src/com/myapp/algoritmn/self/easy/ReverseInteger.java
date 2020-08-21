package com.myapp.algoritmn.self.easy;

public class ReverseInteger {
    private final long input;

    ReverseInteger(long inp) {
        if (inp > Integer.MAX_VALUE || inp < Integer.MIN_VALUE) {
            throw new NumberFormatException("LIMIT MAXED");
        }
        input = inp;

    }

    public int printReverse() {
        long inp = input;
        if (inp > 0 && inp < 9) {
            return (int) inp;
        }
        int reverseNumber = 0;
        long number = inp;
        long reverse = 0;
        while (number > 0) {
            reverse = (reverse * 10 + (number % 10));
            number /= 10;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }

    public static void main(String[] args) {
        ReverseInteger logic = new ReverseInteger(4568975312333333333l);
        System.out.println(logic.printReverse());
        ;
    }
}

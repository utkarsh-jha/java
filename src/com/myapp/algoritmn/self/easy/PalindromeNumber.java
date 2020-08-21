package com.myapp.algoritmn.self.easy;


public class PalindromeNumber {
   private final ReverseInteger var;

    PalindromeNumber(int n) {
        var = new ReverseInteger(n);
        if(n == var.printReverse()){
            System.out.println("palindrome");
        }else
        {
            System.out.println("not palindrome");
        }
    }

    public static void main(String[] args) {
        new PalindromeNumber(127521);
    }


}

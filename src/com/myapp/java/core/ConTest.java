package com.myapp.java.core;

public class ConTest<T> {


    static String concat(String p) {
        p = p + "temp";
        return p;
    }

    static StringBuilder concat(StringBuilder p) {
        p = p.append("temp");
        return p;
    }


    public static void main(String[] args) {
        String p = "amp";
        concat(p);
        System.out.println(p);

        StringBuilder l = new StringBuilder("amp");
        concat(l);
        System.out.println(l);
    }
}

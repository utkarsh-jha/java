package com.myapp.algoritmn.self.easy;

public class LongestCommonPrefix {
    private final String[] list;

    public LongestCommonPrefix(String[] list) {
        this.list = list;
    }

    public String getLongestCommonPrefix() {
        int smallest = 0;
        String commonPrefix = "";
        int loopCount = 0;
        for (int i = 0; i < list.length; i++) {
            if(commonPrefix.length()!=0){

            }else{
                commonPrefix = list[i].charAt(i)+"";
            }
        }
        return "";

    }
}

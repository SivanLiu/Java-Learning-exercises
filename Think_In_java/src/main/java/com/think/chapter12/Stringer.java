package com.think.chapter12;

public class Stringer {
    static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = new String("howdy");
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}

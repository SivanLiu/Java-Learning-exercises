package com.think.chapter6;

class Insert{
    int i =9;
    int j;
    Insert(){
        prt("i = "+ i + ", j = "+j);
        j = 39;
    }

    static int x1 = prt("static Insert.x1 initialized");
    static int prt(String s){
        System.out.println(s);
        return 47;
    }
}
public class Beetle extends Insert {
    int k = prt("Beetl.k initialized");
    Beetle(){
        prt("k = "+k);
        prt("j = " + j);
    }

    static int x2 = prt("static Beetle.x2 initialized");
    static int prt(String s){
        System.out.println(s);
        return 63;
    }

    public static void main(String[] args) {
        prt("Beetle constructor");
        Beetle b = new Beetle();
    }
}

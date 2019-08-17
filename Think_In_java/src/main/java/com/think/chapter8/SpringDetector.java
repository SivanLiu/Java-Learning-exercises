package com.think.chapter8;

import java.util.Hashtable;

/**
 * Looks plausible, but doesn't work right
 */
class Groundhog {
    int ghNumber;

    Groundhog(int n) {
        ghNumber = n;
    }

    @Override
    public int hashCode() {
        return ghNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Groundhog) && (ghNumber == ((Groundhog)obj).ghNumber);
    }
}

class Predictioin {
    boolean shadow = Math.random() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring";
        }
    }
}

public class SpringDetector {

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < 10; i++) {
            hashtable.put(new Groundhog(i), new Predictioin());
        }

        System.out.println("ht = " + hashtable + "\n");
        System.out.println("Looking up prediction for groundhog #3:");
        Groundhog groundhog = new Groundhog(3);
        if (hashtable.containsKey(groundhog)) {
            System.out.println((Predictioin) hashtable.get(groundhog));
        }
    }
}

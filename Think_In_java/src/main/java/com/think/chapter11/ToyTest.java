package com.think.chapter11;

interface HasBatteries {
}

interface Waterproof {
}

interface ShootsThings {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, ShootsThings {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.think.chapter11.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        Class[] faces = c.getInterfaces();
        for (Class face : faces) {
            printInfo(face);
        }

        Class cy = c.getSuperclass();
        Object o = null;
        try {
            o = cy.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(o.getClass());
    }

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
    }
}

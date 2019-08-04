package com.think.chapter7.constructor;

class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce");
    }
}

class PortableLunch extends Meal {
    PortableLunch() {
        System.out.println("PortableLunch");
    }
}

public class Sandwich  extends PortableLunch{
    Bread bread = new Bread();
    Cheese cheese = new Cheese();
    Lettuce lettuce = new Lettuce();

    Sandwich() {
        System.out.println("Sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

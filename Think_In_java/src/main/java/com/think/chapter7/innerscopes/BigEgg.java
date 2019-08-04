package com.think.chapter7.innerscopes;

/**
 * 内部类不可以被覆盖
 */
class Egg {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    private Yolk yolk;

    public Egg() {
        System.out.println("New Egg()");
        yolk = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}

package com.think.chapter12;

/**
 * A constructor for copying an object of the same type, as an attempt to create a local copy
 */
class FruitQualities {
    private int weight;
    private int color;
    private int firmness;
    private int ripeness;
    private int smell;

    FruitQualities() {
    }

    FruitQualities(FruitQualities f) {
        weight = f.weight;
        color = f.color;
        firmness = f.firmness;
        ripeness = f.ripeness;
        smell = f.smell;
    }
}

class Seed {
    Seed() {
    }

    Seed(Seed s) {
    }
}

class Fruit {
    private FruitQualities fq;
    private int seeds;
    private Seed[] s;

    Fruit(FruitQualities q, int seedCount) {
        fq = q;
        seeds = seedCount;
        s = new Seed[seeds];
        for (int i = 0; i < seeds; ++i) {
            s[i] = new Seed();
        }
    }

    Fruit(Fruit f) {
        fq = new FruitQualities(f.fq);
        seeds = f.seeds;
        s = new Seed[f.seeds];
        for (int i = 0; i < seeds; ++i) {
            s[i] = new Seed(f.s[i]);
        }
    }

    protected void addQualities(FruitQualities q) {
        fq = q;
    }

    protected FruitQualities getQualities() {
        return fq;
    }
}

class Tomato extends Fruit {
    Tomato() {
        super(new FruitQualities(), 100);
    }

    Tomato(Tomato tomato) {
        super(tomato);
    }
}

class ZebraQualities extends FruitQualities {
    private int stripedness;

    ZebraQualities() {
    }

    ZebraQualities(ZebraQualities z) {
        super(z);
        stripedness = z.stripedness;
    }
}

class GreenZebra extends Tomato {
    GreenZebra() {

    }

    GreenZebra(GreenZebra g) {
        super(g);
        addQualities(new ZebraQualities());
    }

    void evaluate() {
        ZebraQualities zq = (ZebraQualities) getQualities();
    }
}

public class CopyConstructor {
    public static void ripen(Tomato t) {
        t = new Tomato(t);
        System.out.println("In ripen, t is a " + t.getClass().getName());
    }

    public static void slice(Fruit fruit) {
        fruit = new Fruit(fruit);
        System.out.println("In slice, f is a " + fruit.getClass().getName());
    }

    public static void main(String[] args) {
        Tomato tomato = new Tomato();
        ripen(tomato);
        slice(tomato);
        GreenZebra g = new GreenZebra();
        ripen(g);
        slice(g);
        g.evaluate();
    }
}

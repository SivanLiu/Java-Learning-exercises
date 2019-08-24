package com.think.chapter12;

class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}

class MadScientist extends Scientist {
}

public class HorrorFlick {
    public static void main(String[] args) {
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        MadScientist m = new MadScientist();
        s = (Scientist) s.clone();
        m = (MadScientist) m.clone();
    }
}

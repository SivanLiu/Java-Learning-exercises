package com.think.chapter7;

abstract class Contents {
    abstract public int value();
}

interface Destination {
    String readLabel();
}

public class Parcel3 {

    private class PContents extends Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements com.think.chapter7.innerscopes.Destination {

        private String label;

        private PDestination(String whereTo) {
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public com.think.chapter7.innerscopes.Destination dest(String s) {
        return new PDestination(s);
    }

    public Contents cont() {
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel3 parcel3 = new Parcel3();
        Contents contents = parcel3.cont();

        com.think.chapter7.innerscopes.Destination destination = parcel3.dest("Tanzania");
    }
}

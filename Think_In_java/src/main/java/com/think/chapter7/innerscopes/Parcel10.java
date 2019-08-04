package com.think.chapter7.innerscopes;

abstract class Content {
    abstract public int value();
}

public class Parcel10 {
    private static class PContent extends Content {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class PDestination implements Destination {

        private String label;

        private PDestination(String whereTo) {
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public static Destination dest(String s) {
        return new PDestination(s);
    }

    public static Content cont() {
        return new PContent();
    }

    public static void main(String[] args) {
        Content content = cont();
        Destination destination = dest("Tanzania");
    }
}

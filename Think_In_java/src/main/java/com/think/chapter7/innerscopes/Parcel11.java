package com.think.chapter7.innerscopes;

public class Parcel11 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel11 parcel11 = new Parcel11();
        Parcel11.Contents contents = parcel11.new Contents();
        Destination destination = parcel11.new Destination("Tanzania");
    }
}

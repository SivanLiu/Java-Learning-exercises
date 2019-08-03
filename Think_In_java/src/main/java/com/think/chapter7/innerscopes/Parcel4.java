package com.think.chapter7.innerscopes;

public class Parcel4 {

    public Destination dest(String s) {
        class PDestination implements Destination {

            private String label;

            private PDestination(String whereTo) {
                this.label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        parcel4.dest("Tanzania");
    }
}

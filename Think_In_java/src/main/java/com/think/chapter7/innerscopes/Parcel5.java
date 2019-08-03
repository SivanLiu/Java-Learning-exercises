package com.think.chapter7.innerscopes;

/**
 * 在任意作用域内嵌套内部类
 */
public class Parcel5 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getShip() {
                    return id;
                }

                TrackingSlip trackingSlip = new TrackingSlip("slip");
                String s = trackingSlip.getShip();
            }
        }

    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        parcel5.track();
    }
}

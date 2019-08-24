package com.think.chapter12;

/**
 * Cloning a composed object
 */
class DepthReading implements Cloneable {
    private double depth;

    public DepthReading(double depth) {
        this.depth = depth;
    }

    @Override
    protected Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }
}

class TemperatureReading implements Cloneable {
    private long time;
    private double temperature;

    public TemperatureReading(double temperature) {
        time = System.currentTimeMillis();
        this.temperature = temperature;
    }

    @Override
    protected Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }
}

class OceanReading implements Cloneable {
    private DepthReading depth;
    private TemperatureReading temperatureReading;

    public OceanReading(double tdata, double ddata) {
        temperatureReading = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    @Override
    protected Object clone() {
        OceanReading o = null;
        try {
            o = (OceanReading) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //Must clone handles
        o.depth = (DepthReading) o.depth.clone();
        o.temperatureReading = (TemperatureReading) o.temperatureReading.clone();
        return o;
    }

}

public class DeepCopy {
    public static void main(String[] args) {
        OceanReading reading = new OceanReading(33.9, 100.5);
        OceanReading r = (OceanReading) reading.clone();
    }
}

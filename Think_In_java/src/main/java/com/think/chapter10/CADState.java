package com.think.chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
 * Saving and restoring the state of a pretend CAD system
 */
abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random r = new Random();
    private static int counter = 0;

    abstract public void setColor(int newColor);

    abstract public int getColor();

    public Shape(int xVal, int yVal, int dim) {
        this.xPos = xVal;
        this.yPos = yVal;
        this.dimension = dim;
    }

    @Override
    public String toString() {
        return "Shape{" + "xPos=" + xPos + ", yPos=" + yPos + ", dimension=" + dimension + '}';
    }

    public static Shape randomFactory() {
        int xVal = r.nextInt() % 100;
        int yVal = r.nextInt() % 100;
        int dim = r.nextInt() % 100;
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);

        }
    }
}

class Circle extends Shape {

    private static int color = RED;

    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }

    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }
}

class Line extends Shape {

    private static int color = RED;

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public static void serializeState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

public class CADState {
    public static void main(String[] args) throws Exception {
        Vector shapeTypes, shapes;
        if (args.length == 0) {
            shapeTypes = new Vector();
            shapes = new Vector();
            //Add handles to the class objects
            shapeTypes.addElement(Circle.class);
            shapeTypes.addElement(Square.class);
            shapeTypes.addElement(Line.class);

            //Make some shapes
            for (int i = 0; i < 10; ++i) {
                shapes.addElement(Shape.randomFactory());
            }

            //set all the static colors to GREEN
            for (int i = 0; i < 10; i++) {
                ((Shape) shapes.elementAt(i)).setColor(Shape.GREEN);
            }

            //Save the state Vector
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
            out.writeObject(shapeTypes);
            Line.serializeState(out);
            out.writeObject(shapes);
        } else {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
            //Read in the same order they were written
            shapeTypes = (Vector) in.readObject();
            Line.deserializeStaticState(in);
            shapes = (Vector) in.readObject();
        }
        //Display the shapes
        System.out.println(shapes);
    }
}

package com.think.chapter10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Controlling serialization by adding own writeObject() and readObject() methods
 */
public class SerialCtl implements Serializable {
    String a;
    transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before: \n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            ObjectOutputStream o = new ObjectOutputStream(buf);
            o.writeObject(sc);
            //Now get it back;
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            SerialCtl sc2 = (SerialCtl) in.readObject();
            System.out.println("After:\n" + sc2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.think.chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Demonstrates the "transient" keyword
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    Logon(String name, String pwd) {
        this.username = name;
        this.password = pwd;
    }

    @Override
    public String toString() {
        String pwd = (password == null) ? "(n/a)" : password;
        return "Logon{" + "date=" + date + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

    public static void main(String[] args) {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
            o.writeObject(a);
            o.close();
            //Delay
            int seconds = 5;
            long t = System.currentTimeMillis() + seconds * 1000;
            while (System.currentTimeMillis() < t)
                ;
            //Now get them back;
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
            System.out.println("Recovering object at " + new Date());
            a = (Logon) in.readObject();
            System.out.println("logon a = " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

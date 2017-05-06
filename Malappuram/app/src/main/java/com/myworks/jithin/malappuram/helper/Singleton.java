package com.myworks.jithin.malappuram.helper;

/**
 * Created by jithin on 6/5/17.
 */

public class Singleton{
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
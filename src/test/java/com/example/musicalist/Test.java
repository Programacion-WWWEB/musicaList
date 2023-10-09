package com.example.musicalist;

public class Test {
    public static void main(String[] args) {
        System.out.println("Versión de Java: " + System.getProperty("java.version"));
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classpath);
    }
}

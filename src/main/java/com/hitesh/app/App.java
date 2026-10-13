package com.hitesh.app;

public class App {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello from Jenkins pipeline! 2 + 3 = " + new App().add(2, 3));
    }
}

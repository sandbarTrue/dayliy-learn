package com.example.dayliy.learn.interfacetest;

public class Iphone implements Typec {
    @Override
    public void run(String mType) {
        System.out.println("Iphone run");
    }

    @Override
    public void link() {
        System.out.println("Iphone link");
    }
}

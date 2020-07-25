package com.example.dayliy.learn.interfacetest;

public class Andriod implements Typec, Usb {
    @Override
    public void run(String mType) {
        System.out.println("Andriod run");
    }

    @Override
    public void link() {
        System.out.println("Andriod link");
    }

    @Override
    public void UsbRun(String mType) {
        System.out.println("Andriod run usb");
    }
}

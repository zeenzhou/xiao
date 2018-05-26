package com.zeen.proxy;

public class Tank implements Moveable {
    @Override
    public void move() {
        System.out.println("Tanks is moving....");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

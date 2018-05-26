package com.zeen.proxy;

public class Client {
    public static void main(String[] args) {
        try {
            Tank t = new Tank();
            Moveable tp = (Moveable) Proxy.newProxyInstance(Moveable.class,new TimerHandler(t));
            tp.move();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

package com.zeen.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {
    public Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method md) {
        long start = System.currentTimeMillis();
        System.out.println("start time:" + start);
        System.out.println(o.getClass().getName());
        try {
            md.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("spend times:" + (end - start));
    }
}

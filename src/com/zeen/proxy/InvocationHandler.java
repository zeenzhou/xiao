package com.zeen.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Object o, Method md) throws InvocationTargetException, IllegalAccessException;
}

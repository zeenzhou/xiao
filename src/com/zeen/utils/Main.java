package com.zeen.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Date date = new Date();
        //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH");
        System.out.println(sdf.format(date));

        //for (int i = 0; i < 5; i++) {
        //    TestThread t = new TestThread();
        //    t.start();
        //}

        System.out.println("HOUR_OF_DAY: " + Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

    }
}


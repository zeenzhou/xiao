/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.zeen.test;

import java.util.Date;

/**
 *  Thread Test
 *
 * @author zhouliang at 2018/3/2 9:10
 */
public class TestThread {
    public static void main(String[] args) {
        long beginTime = new Date().getTime();
        //for (int i = 0; i < 1000; i++) {
        //    new Thread(new RunThread("RunThreadName",i)).start();
        //}

        // 多线程执行,并发执行
        for (int i = 0; i < 10000; i++) {
          new RunThread2("RunThreadName2",i).start();
        }

        //顺序执行,没有多线程的意义了
        //for (int i = 0; i < 1000; i++) {
        //  new RunThread2("RunThreadName2",i).run();
        //}

        // 这个时间一般就短,0.07秒
        System.out.println("run start time is:" + (double) (new Date().getTime() -beginTime)/1000 + " seconds..");
    }
}


class RunThread implements Runnable {
    String name;
    int id;

    public RunThread(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("ThreadName:" + id + " is running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class  RunThread2 extends Thread {
    String name;
    int id;

    public RunThread2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("ThreadName2:" + id + " is running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


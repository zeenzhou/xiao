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

/**
 * TODO？
 *
 * @author zhouliang at 2018/5/15 10:42
 */
public class ValuePass {

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        swap(x, y);
        System.out.println(x);


        Integer x1 = 2;
        Integer y1 = 3;
        swap(x1, y1);
        System.out.println(x1);

        // 引用不会改变
        Test t =new Test(1,2);
        System.out.println(t);
        change(t);
        System.out.println(t.x);
        System.out.println(t.y);
        System.out.println(t);

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void change(Test t) {
        t.x= 10089;
        t.y=2008;
    }


    static class Test {
        private  int x;
        private  int y;

        public Test(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}

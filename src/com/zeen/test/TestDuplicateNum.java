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
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * TODO？
 *
 * @author zhouliang at 2018/3/1 10:56
 */
public class TestDuplicateNum {

    public static void main(String[] args) {
        System.out.println(new Date());
        Set set =new HashSet<>();

        //set.add(1);
        //set.add(2);
        //set.add(3);
        //set.add(1);
        int ramdon = (int) (Math.random()*100000000);
        System.out.println("the ramdon num is :" + ramdon);

        set.add(ramdon);
        boolean isOver = false;
        for (int k = 0; k < 1000 ; k++) {
            for (int i = 100000*k; i < 100000*(k+1); i++) {
                int oldSize = set.size();
                set.add(i);
                if (oldSize == set.size()) {
                    System.out.println("the duplicate num is :" + i);
                    isOver = true;
                    break;
                }
            }
            if (isOver) {
                break;
            } else {
                set.clear();
                set.add(ramdon);
            }
        }

        //System.out.println(set);
        System.out.println(set.size());
        System.out.println(new Date());

    }
}

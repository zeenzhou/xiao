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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO？
 *
 * @author zhouliang at 2018/4/27 9:33
 */
public class NullTest {
    public static void main(String[] args) {
        System.out.println("start...");
        //List<String> list = new ArrayList();
        //list = null;
        //for(String str : list) {
        //    System.out.println(str);
        //}

        BigDecimal num = new BigDecimal(12);
        BigDecimal num2 = new BigDecimal(12);
        num2 = null;
        System.out.println(num.subtract(num2));

        System.out.println("end");
    }
}

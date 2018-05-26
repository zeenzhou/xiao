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

import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO？
 *
 * @author zhouliang at 2018/4/9 17:45
 */
public class TestData {
    public static void main(String[] args) {
        Calendar ca = Calendar.getInstance();
        int currentDay = ca.get(Calendar.DATE);
        System.out.println(currentDay);


        BigDecimal b = new BigDecimal(-89.9);
        System.out.println(b);
        System.out.println(b.abs());

        System.out.println(getIntervalByDays(new Date(),new Date()));
        System.out.println(getIntervalByDays(getDate("2016-05-12 09:59:59"),new Date()));
        System.out.println(getIntervalByDays(getDate("2018-05-10 09:59:59"),new Date()));
        System.out.println(getIntervalByDays(getDate("2017-05-18 09:59:59"),getDate("2018-05-18 09:59:59")));
    }


    /**
     * 计算两个日期之间相差的天数。
     *
     * @param lower 时间下限。
     * @param upper 时间上限。
     * @return 相差天数。
     */
    public static int getIntervalByDays(Date lower, Date upper) {
        if (lower == null || upper == null) return 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            lower = sdf.parse(sdf.format(lower));
            upper = sdf.parse(sdf.format(upper));
        } catch (ParseException ex) {
            throw new IllegalStateException(ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(lower);
        long time1 = cal.getTimeInMillis();
        cal.setTime(upper);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static Date getDate(String simpleDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(simpleDate);
            calendar.setTime(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(new Date(calendar.getTimeInMillis()));
        return new Date(calendar.getTimeInMillis());
    }
}

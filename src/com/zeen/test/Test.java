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

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * TODO？
 *
 * @author zhouliang at 2017/12/8 13:42
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String backUrl = "http://www.my089.com?id=56&u=uiuiujn&sign=9089898eddfdf";
        System.out.println(backUrl);

        String encodeUrl  = URLEncoder.encode(backUrl, "UTF-8");
        System.out.println(encodeUrl);

        String decodeUrl  = URLDecoder.decode(encodeUrl, "UTF-8");

        System.out.println(decodeUrl);

        String decodeUrlAgain = URLDecoder.decode(decodeUrl, "UTF-8");
        System.out.println(decodeUrlAgain);

        String decodeUrlAgain02 = URLDecoder.decode(decodeUrlAgain, "UTF-8");
        System.out.println(decodeUrlAgain02);

        String decodeUrlAgain03 = URLDecoder.decode(decodeUrlAgain02, "UTF-8");
        System.out.println(decodeUrlAgain03);


        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < 89; i++) {

        }


        try {
            throw new IOException();
        } catch (java.io.IOException e) {

        } finally {

        }

        try {

        } finally {

        }

        try {

        } catch (Error e) {

        } finally {

        }

        try {

        } catch (Throwable t) {

        } finally {

        }

        try {

        } catch (NullPointerException e) {

        } catch (Exception e) {

        } finally {

        }



    }

}

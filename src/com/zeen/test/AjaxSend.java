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


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;

import java.io.IOException;

/**
 * AjaxSend
 *
 * @author zhouliang at 2018/2/6 17:43
 */
public class AjaxSend {
    //private static String url = "https://bbs.my089.com/userSignByDay";
    private static String url = "https://sso.my089.com/sso/login?back_url=https://bbs.my089.com/userSignByDay";

    public static void main(String[] args) {

        HttpClient client = new HttpClient();
        String body = "[{\"username\":zeenzhou,\"encryption\":989898}]";

        method(client, url, body);
    }

    @SuppressWarnings("deprecation")
    public static void method(HttpClient client, String url, String body) {

        PostMethod method = new PostMethod(url);
        method.setRequestBody(body);// addParameters(postData);

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println(new String(responseBody, "utf-8"));
        }
        //catch (HttpException e) {
        //    System.err.println("Fatal protocol violation: " + e.getMessage());
        //    e.printStackTrace();
        //}
        catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
    }

}

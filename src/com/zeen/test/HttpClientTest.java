///*************************************************************************
// *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
// *
// *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
// *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
// * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
// * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
// * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
// * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
// DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
// *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
// *************************************************************************/
//package com.test;
//
//import org.apache.http.Header;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.client.utils.DateUtils;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.cookie.CookieOrigin;
//import org.apache.http.cookie.MalformedCookieException;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.cookie.DefaultCookieSpec;
//import org.apache.http.message.BasicHeader;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
///**
// * TODO？
// *
// * @author zhouliang at 2018/3/2 10:56
// */
//public class HttpClientTest {
//
//    String url = "wwww.baidu.com";
//
//    class MyCookieSpec extends DefaultCookieSpec {
//        @Override
//        public List parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
//            String value = header.getValue();
//            String prefix = "Expires=";
//            if (value.contains(prefix)) {
//                String expires = value.substring(value.indexOf(prefix) + prefix.length());
//                expires = expires.substring(0, expires.indexOf(";"));
//                String date = DateUtils.formatDate(new Date(Long.parseLong(expires) * 1000L), "EEE, dd-MMM-yy HH:mm:ss z");
//                value = value.replaceAll(prefix + "\\d{10};", prefix + date + ";");
//            }
//            header = new BasicHeader(header.getName(), value);
//            return super.parse(header, cookieOrigin);
//        }
//    }
//
//    @Test
//    public void getCookie() {
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        Registry cookieSpecProviderRegistry = RegistryBuilder.create()
//            .register("myCookieSpec", context -> new MyCookieSpec()).build();//注册自定义CookieSpec
//
//        HttpClientContext context = HttpClientContext.create();
//        context.setCookieSpecRegistry(cookieSpecProviderRegistry);
//
//        HttpGet get = new HttpGet(url);
//        get.setConfig(RequestConfig.custom().setCookieSpec("myCookieSpec").build());
//
//        try {
//            CloseableHttpResponse response = httpClient.execute(get, context);
//            try {
//                System.out.println(">>>>>>headers:");
//                Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
//                System.out.println(">>>>>>cookies:");
//                context.getCookieStore().getCookies().forEach(System.out::println);
//            } finally {
//                response.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
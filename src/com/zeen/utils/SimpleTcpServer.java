package com.zeen.utils; /*************************************************************************
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

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 最简单的tcp服务器
 *
 * @author zhouliang at 2017/11/11 18:05
 */
public class SimpleTcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String s = null;
            while ((s = br.readLine()) != null && !s.equals(""))
                System.out.println(s);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("HTTP/1.1 200 OK\n");
            bw.write("Content-Type: text/html; charset=UTF-8\n\n");
            bw.write("<html>\n" +
                "<head>\n" +
                "    <title>first page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Hello World!</h1>\n" +
                "</body>\n" +
                "</html>\n");
            bw.flush();

            br.close();
            bw.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
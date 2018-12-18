package com.northleaf.tomcat;

import com.northleaf.http.Request;
import com.northleaf.http.Response;
import com.northleaf.servlet.Servlet;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 15:54 2018/12/18
 */
public class SocketProcess extends Thread {

    protected Socket socket;

    public SocketProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());

            Servlet servlet = MyTomcat.servletMapping.get(request.getUrl());

            if (servlet != null) {
                servlet.service(request, response);
            } else {
                String res = Response.responseHeader + "Hello World";
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(res.getBytes());
                outputStream.flush();
                outputStream.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

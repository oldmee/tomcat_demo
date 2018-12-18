package com.northleaf.servlet;

import com.northleaf.http.Request;
import com.northleaf.http.Response;

import java.io.OutputStream;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 15:35 2018/12/18
 */
public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response)  {
        try {
            OutputStream outputStream = response.outputStream;
            String res = Response.responseHeader+"Hello,welcome to here !";
            outputStream.write(res.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
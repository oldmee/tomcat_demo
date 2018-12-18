package com.northleaf.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 15:33 2018/12/18
 */
public class Response {


    public OutputStream outputStream;

    public static final String responseHeader="HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";

    public Response(OutputStream outputStream) throws IOException {
        this.outputStream= outputStream;
    }

}

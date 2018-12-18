package com.northleaf.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: R.oldmee
 * @Description:
 * @Date: Create in 15:04 2018/12/18
 */
public class Request {
    private String method;
    private String url;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Request(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //将读取到的第一行显按空格拆分出方法与url
        String[] methodAndUrl = bufferedReader.readLine().split(" ");
        this.method= methodAndUrl[0];
        this.url=methodAndUrl[1];
    }
}

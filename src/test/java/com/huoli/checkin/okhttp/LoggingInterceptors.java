/**
 * 
 */
package com.huoli.checkin.okhttp;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public class LoggingInterceptors {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptors.class);
    private final OkHttpClient client = new OkHttpClient();
    public LoggingInterceptors() {
        client.networkInterceptors().add(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                long t1 = System.nanoTime();
                Request request = chain.request();
                logger.info(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));
                Response response = chain.proceed(request);
                long t2 = System.nanoTime();
                logger.info(String.format("Received response for %s in %.1fms%n%s",
                request.url(), (t2 - t1) / 1e6d, response.headers()));
                return response;
            }
        });
    }
    public void run() throws Exception {
        Request request = new Request.Builder()
        .url("https://publicobject.com/helloworld.txt")
        .build();
        Response response = client.newCall(request).execute();
        response.body().close();
    }
    public static void main(String... args) throws Exception {
        new LoggingInterceptors().run();
    }
}

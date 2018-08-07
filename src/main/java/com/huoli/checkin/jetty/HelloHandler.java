package com.huoli.checkin.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloHandler extends AbstractHandler {  
    private static Logger logger = LoggerFactory.getLogger(HelloHandler.class);
    
    public void handle(String target, Request baseRequest,  
            HttpServletRequest request, HttpServletResponse response)  
            throws IOException, ServletException {  
        response.setContentType("text/html;charset=utf-8");  
        response.setStatus(HttpServletResponse.SC_OK);  
        baseRequest.setHandled(true);  
        logger.debug("{}","hello world!");
        response.getWriter().println("<h1>Hello World</h1>");  
    }  
}  

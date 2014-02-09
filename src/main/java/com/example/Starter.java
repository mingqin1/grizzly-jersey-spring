/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;

import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;
//import org.glassfish.grizzly.servlet.ServletRegistration;
//import org.glassfish.grizzly.servlet.WebappContext;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class Starter {

    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer();
        NetworkListener listener = new NetworkListener("grizzly2", "localhost", 3388);
        server.addListener(listener);
        WebappContext ctx = new WebappContext("ctx","/");
        final ServletRegistration reg = ctx.addServlet("spring", new SpringServlet());
        reg.addMapping("/");
        ctx.addContextInitParameter("contextConfigLocation", "classpath:spring-context.xml");
        ctx.addListener("org.springframework.web.context.ContextLoaderListener");
        ctx.addListener("org.springframework.web.context.request.RequestContextListener");
        ctx.deploy(server);

        server.start();

        System.in.read();

    }
}

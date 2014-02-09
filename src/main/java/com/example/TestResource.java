/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ming Qin <ming.qin@live.com>
 * 
 */

@Component
@Path("/")
public class TestResource {

    @GET
    @Produces("text/html")
    public String getIt() {
        return "hello world";
    }

    @GET
    @Path("/test")
    @Produces("text/html")
    public String test() {
        return "test";
    }

    @GET
    @Path("/test2")
    @Produces("text/html")
    public String test2() {
        return "test2";
    }
}

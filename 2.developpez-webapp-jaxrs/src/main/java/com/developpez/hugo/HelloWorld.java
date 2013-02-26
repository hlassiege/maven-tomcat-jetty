package com.developpez.hugo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class HelloWorld {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    @GET
    @Path("/hello/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {

        LOG.info("Hello {}", input);
        return input;
    }
}


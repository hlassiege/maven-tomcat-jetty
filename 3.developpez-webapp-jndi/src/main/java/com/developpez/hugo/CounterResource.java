
package com.developpez.hugo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

@Path("/visit")
public class CounterResource {

    @Autowired
    private CounterDao counterDao;

    @GET
    @Produces("text/plain")
    public int show() {
        counterDao.incrementCptr();
        int count = counterDao.getValue();
        return count;
    }
}
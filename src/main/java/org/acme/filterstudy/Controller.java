package org.acme.filterstudy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")

public class Controller {
    @GET
    @Path("/greeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greeting() {
        return Response.ok("{\"message\":\"Hello, authenticated user!\"}").build();
    }
    @GET
    @Path("/greeting2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response greeting2() {
        return Response.ok("{\"message\":\"Hello, authenticated user!2\"}").build();
    }
}

package jp.example;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/example")
public class ExampleResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        return Response.ok(new Example("Hello")).build();
    }
}

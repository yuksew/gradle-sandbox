package jp.example;

import org.junit.Test;

import static org.junit.Assert.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.test.*;
import org.junit.*;

public class ExampleResourceTest extends BaseResourceTest {
    @BeforeClass
    public static void beforeClass() throws Exception {
        addPerRequestResource(ExampleResource.class);
    }
    @Test
    public void index() throws Exception {
        Client c = ClientBuilder.newClient();
        String u = TestPortProvider.generateURL("/example");
        WebTarget target = c.target(u);
        
        Response r = target.request().get();
        assertEquals(200, r.getStatus());
        Example e = r.readEntity(Example.class);
        assertEquals("Hello", e.getName());
        
        r.close();
        c.close();
    }
}

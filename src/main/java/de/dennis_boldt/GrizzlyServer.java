package de.dennis_boldt;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class GrizzlyServer {

    private final String HOSTNAME = "localhost";
    private final Integer PORT = 9999;
    private final String JAXRS_RESOURCES = "de.dennis_boldt";

    public GrizzlyServer(int port) {

        // Create the URI
        URI uri = UriBuilder.fromUri("http://" + HOSTNAME).port(PORT).build();

        // Create the ResourceConfig
        ResourceConfig rc = new PackagesResourceConfig(JAXRS_RESOURCES);

        // Start the server
        try {
            HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);
            System.out.println("Grizzly server started.");
            System.in.read();
            System.out.print("Stop server...");
            server.stop();
            System.out.println("done");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GrizzlyServer(9999);
    }
}
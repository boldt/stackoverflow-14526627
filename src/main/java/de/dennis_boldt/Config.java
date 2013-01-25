package de.dennis_boldt;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

/**
 * The configuration
 *
 * @author Dennis Boldt
 *
 */
public class Config {

    public static final String HOSTNAME = "localhost";
    public static final Integer PORT = 9999;
    public static final String JAXRS_RESOURCES = "de.dennis_boldt";

    public static URI getBaseURI() {
        return UriBuilder.fromUri("http://" + Config.HOSTNAME).port(Config.PORT).build();
    }

    public static ResourceConfig getResourceConfig() {
        final Map<String, Object> init_params = new HashMap<String, Object>();
        init_params.put("com.sun.jersey.config.property.packages", Config.JAXRS_RESOURCES);
        return new PackagesResourceConfig(init_params);
    }

}

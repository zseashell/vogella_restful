/**
 * 
 */
package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class TestClient {
    
    private static final String url = "http://10.100.8.70:9090/vogella_RestFul/rest";
    
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget resourceTarget = client.target(url).path("hello");
        Invocation.Builder invocationBuilder = 
            resourceTarget.request(MediaType.TEXT_PLAIN);
//            resourceTarget.request(MediaType.TEXT_XML);
//            resourceTarget.request(MediaType.TEXT_HTML);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

}

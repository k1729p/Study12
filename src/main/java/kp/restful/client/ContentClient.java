package kp.restful.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import kp.restful.ResearchRestfulHelper;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper for JAX-RS client for {@link kp.restful.data.Content} objects.
 */
public class ContentClient {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final URI[] CONTENT_URI_ARR = {
            URI.create("http://localhost:8080/content/pq/"),
            URI.create("http://localhost:8080/content/c/")
    };
    private static final String CLASS_NAME = ContentClient.class.getSimpleName();

    /**
     * Private constructor to prevent instantiation.
     */
    private ContentClient() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Processes content client.
     */
    public static void process() {

        logger.info("process(): opening client-side communication");
        try (Client client = ClientBuilder.newClient()) {
            for (int i = 0; i < CONTENT_URI_ARR.length; i++) {
                ResearchRestfulHelper.setNumber(i + 1);
                final URI uri = CONTENT_URI_ARR[i];
                if (i > 0) {
                    ResearchRestfulHelper.addEmptyLineToReport();
                }
                final String uriMsg = "calling uri[%s]".formatted(uri);
                ResearchRestfulHelper.addToReport(CLASS_NAME, "process", uriMsg);

                final WebTarget webResourceTarget = client.target(uri);
                final Invocation.Builder invocationBuilder =
                        webResourceTarget.path("P-a-t-P-a-r").queryParam("que_par", "Q-u-e-P-a-r")
                                .request();
                final Response response = invocationBuilder.get();

                final String statusMsg = "%s".formatted(response.getStatusInfo().getReasonPhrase());
                final String entityMsg = "response entity[%s]".formatted(response.readEntity(String.class));
                ResearchRestfulHelper.addToReport(CLASS_NAME, "process", statusMsg, entityMsg);

                if (logger.isLoggable(Level.INFO)) {
                    logger.info("process(): %s, response status[%s], %s".formatted(uriMsg, statusMsg, entityMsg));
                }
            }
        }
        logger.info("process(): client-side communication closed");
    }
}

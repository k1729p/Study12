package kp.restful.client;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import kp.restful.ResearchRestfulHelper;

/**
 * The wrapper of JAX-RS client for the <B>Content</B> objects.
 *
 */
public class ContentClient {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private static final URI[] CONTENT_URI_ARR = { /*-*/
			URI.create("http://localhost:8080/content/pq/"), /*-*/
			URI.create("http://localhost:8080/content/c/")/*-*/
	};
	private static final String CLASS_NAME = ContentClient.class.getSimpleName();

	/**
	 * The constructor.
	 */
	private ContentClient() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Processes content client.
	 * 
	 */
	public static void process() {

		if (logger.isLoggable(Level.INFO)) {
			logger.info("process(): opening client-side communication");
		}
		final Client client = ClientBuilder.newClient();
		for (int i = 0; i < CONTENT_URI_ARR.length; i++) {
			ResearchRestfulHelper.setNumber(i + 1);
			final URI uri = CONTENT_URI_ARR[i];
			if (i > 0) {
				ResearchRestfulHelper.addEmptyLineToReport();
			}
			final String uriMsg = String.format("calling uri[%s]", uri);
			ResearchRestfulHelper.addToReport(CLASS_NAME, "process", uriMsg);

			final WebTarget target = client.target(uri);
			final Invocation.Builder invocationBuilder = target.path("P-a-t-P-a-r").queryParam("que_par", "Q-u-e-P-a-r")
					.request();
			final Response response = invocationBuilder.get();

			final String statusMsg = String.format("%s", response.getStatusInfo().getReasonPhrase());
			final String entityMsg = String.format("response entity[%s]", response.readEntity(String.class));
			ResearchRestfulHelper.addToReport(CLASS_NAME, "process", statusMsg, entityMsg);

			if (logger.isLoggable(Level.INFO)) {
				logger.info(String.format("process(): %s, response status[%s], %s", uriMsg, statusMsg, entityMsg));
			}
		}
		client.close();
		if (logger.isLoggable(Level.INFO)) {
			logger.info("process(): client-side communication closed");
		}
	}
}

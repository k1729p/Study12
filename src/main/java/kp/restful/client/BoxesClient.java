package kp.restful.client;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kp.restful.ResearchRestfulHelper;
import kp.restful.data.Box;

/**
 * The wrapper of JAX-RS client for the {@link Box}. objects.
 *
 */
public class BoxesClient {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private static final URI BOXES_URI = URI.create("http://localhost:8080/boxes/");
	private static final String CLASS_NAME = BoxesClient.class.getSimpleName();

	/**
	 * The constructor.
	 */
	private BoxesClient() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Processes boxes client.
	 * 
	 */
	public static void process() {

		if (logger.isLoggable(Level.INFO)) {
			logger.info("process(): opening client-side communication");
		}
		final Client client = ClientBuilder.newClient();
		int number = 1;

		ResearchRestfulHelper.setNumber(number++);
		callCreate(client, "A");
		ResearchRestfulHelper.setNumber(number++);
		callCreate(client, "B");
		ResearchRestfulHelper.setNumber(number++);
		callCreate(client, "C");

		ResearchRestfulHelper.setNumber(number++);
		callRead(client, 1);
		ResearchRestfulHelper.setNumber(number++);
		callReadList(client);

		ResearchRestfulHelper.setNumber(number++);
		callUpdate(client, 1, "X");
		ResearchRestfulHelper.setNumber(number++);
		callUpdate(client, 1, "X");

		ResearchRestfulHelper.setNumber(number++);
		callDelete(client, 2);
		ResearchRestfulHelper.setNumber(number++);
		callReadList(client);

		ResearchRestfulHelper.setNumber(number++);
		// lower case letter is not valid pattern in 'Box'
		callCreate(client, "a");
		ResearchRestfulHelper.setNumber(number++);
		// lower case letter is not valid pattern in 'Box'
		callUpdate(client, 1, "a");
		ResearchRestfulHelper.setNumber(number++);
		callUpdate(client, 12345, "A");
		ResearchRestfulHelper.setNumber(number);
		callDelete(client, 12345);

		client.close();
		if (logger.isLoggable(Level.INFO)) {
			logger.info("process(): client-side communication closed");
		}
	}

	/**
	 * Calls entity creation.
	 * 
	 * @param client the {@link Client}
	 * @param text   the text
	 */
	private static void callCreate(Client client, String text) {

		final WebTarget target = client.target(BOXES_URI);
		final Entity<Box> entity = Entity.entity(new Box(text), MediaType.APPLICATION_JSON);
		final Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildPost(entity);

		final String statusMsg;
		final String message;
		try (Response response = invocation.invoke()) {
			statusMsg = response.getStatusInfo().getReasonPhrase();
			message = String.format("text[%s], location[%s]", text, response.getLocation());
		}
		ResearchRestfulHelper.addToReport(CLASS_NAME, "callCreate", statusMsg, message);
		ResearchRestfulHelper.addEmptyLineToReport();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("callCreate(): response status[%s], %s", statusMsg, message));
		}
	}

	/**
	 * Calls entity reading.
	 * 
	 * @param client the {@link Client}
	 * @param id     the id
	 */
	private static void callRead(Client client, int id) {

		final WebTarget target = client.target(BOXES_URI);
		final Invocation invocation = target.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).buildGet();

		final String statusMsg;
		final String message;
		try (Response response = invocation.invoke()) {
			statusMsg = response.getStatusInfo().getReasonPhrase();
			message = String.format("entity[%s]", response.readEntity(String.class));
		}
		ResearchRestfulHelper.addToReport(CLASS_NAME, "callRead", statusMsg, message);
		ResearchRestfulHelper.addEmptyLineToReport();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("callRead(): response status[%s], %s", statusMsg, message));
		}
	}

	/**
	 * Calls list reading.
	 * 
	 * @param client the {@link Client}
	 */
	private static void callReadList(Client client) {

		final WebTarget target = client.target(BOXES_URI);
		final Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();

		final String statusMsg;
		final String message;
		try (Response response = invocation.invoke()) {
			statusMsg = response.getStatusInfo().getReasonPhrase();
			message = String.format("entity%s", response.readEntity(String.class));
		}
		ResearchRestfulHelper.addToReport(CLASS_NAME, "callReadList", statusMsg, message);
		ResearchRestfulHelper.addEmptyLineToReport();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("callReadList(): response status[%s]%n\t%s", statusMsg, message));
		}
	}

	/**
	 * Calls entity updating.
	 * 
	 * @param client the {@link Client}
	 * @param id     the id
	 * @param text   the text
	 */
	private static void callUpdate(Client client, int id, String text) {

		final WebTarget target = client.target(BOXES_URI);
		final Entity<Box> entity = Entity.entity(new Box(id, text), MediaType.APPLICATION_JSON);
		final String idStr = String.valueOf(id);
		final Invocation invocation = target.path(idStr).request(MediaType.APPLICATION_JSON).buildPut(entity);

		final String statusMsg;
		try (Response response = invocation.invoke()) {
			statusMsg = response.getStatusInfo().getReasonPhrase();
		}
		final String message = String.format("id[%d], text[%s]", id, text);
		ResearchRestfulHelper.addToReport(CLASS_NAME, "callUpdate", statusMsg, message);
		ResearchRestfulHelper.addEmptyLineToReport();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("callUpdate(): response status[%s], %s", statusMsg, message));
		}
	}

	/**
	 * Calls entity deleting.
	 * 
	 * @param client the {@link Client}
	 * @param id     the id
	 */
	private static void callDelete(Client client, int id) {

		final WebTarget target = client.target(BOXES_URI);
		final String idStr = String.valueOf(id);
		final Invocation invocation = target.path(idStr).request(MediaType.APPLICATION_JSON).buildDelete();

		final String statusMsg;
		try (Response response = invocation.invoke()) {
			statusMsg = response.getStatusInfo().getReasonPhrase();
		}
		final String message = String.format("id[%d]", id);
		ResearchRestfulHelper.addToReport(CLASS_NAME, "callDelete", statusMsg, message);
		ResearchRestfulHelper.addEmptyLineToReport();
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("callDelete(): response status[%s], %s", statusMsg, message));
		}
	}
}
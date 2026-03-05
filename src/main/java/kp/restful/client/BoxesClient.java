package kp.restful.client;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import kp.restful.ResearchRestfulHelper;
import kp.restful.data.Box;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper for JAX-RS client for the {@link Box} objects.
 */
public class BoxesClient {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final URI BOXES_URI = URI.create("http://localhost:8080/boxes/");
    private static final String CLASS_NAME = BoxesClient.class.getSimpleName();

    /**
     * Private constructor to prevent instantiation.
     */
    private BoxesClient() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Processes the boxes client.
     */
    public static void process() {

        logger.info("process(): opening client-side communication");
        try (Client client = ClientBuilder.newClient()) {
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
            // lower case letter is not a valid pattern in 'Box'
            callCreate(client, "a");
            ResearchRestfulHelper.setNumber(number++);
            // lower case letter is not a valid pattern in 'Box'
            callUpdate(client, 1, "a");
            ResearchRestfulHelper.setNumber(number++);
            callUpdate(client, 12345, "A");
            ResearchRestfulHelper.setNumber(number);
            callDelete(client, 12345);
        }
        logger.info("process(): client-side communication closed");
    }

    /**
     * Calls entity creation.
     *
     * @param client the {@link Client}
     * @param text   the text
     */
    private static void callCreate(Client client, String text) {

        final WebTarget webResourceTarget = client.target(BOXES_URI);
        final Entity<Box> entity = Entity.entity(new Box(text), MediaType.APPLICATION_JSON);
        final Invocation invocation = webResourceTarget.request(MediaType.APPLICATION_JSON).buildPost(entity);

        final String statusMsg;
        final String message;
        try (Response response = invocation.invoke()) {
            statusMsg = response.getStatusInfo().getReasonPhrase();
            message = "text[%s], location[%s]".formatted(text, response.getLocation());
        }
        ResearchRestfulHelper.addToReport(CLASS_NAME, "callCreate", statusMsg, message);
        ResearchRestfulHelper.addEmptyLineToReport();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("callCreate(): response status[%s], %s".formatted(statusMsg, message));
        }
    }

    /**
     * Calls entity reading.
     *
     * @param client the {@link Client}
     * @param id     the id
     */
    private static void callRead(Client client, int id) {

        final WebTarget webResourceTarget = client.target(BOXES_URI);
        final Invocation invocation =
                webResourceTarget.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).buildGet();

        final String statusMsg;
        final String message;
        try (Response response = invocation.invoke()) {
            statusMsg = response.getStatusInfo().getReasonPhrase();
            message = "entity[%s]".formatted(response.readEntity(String.class));
        }
        ResearchRestfulHelper.addToReport(CLASS_NAME, "callRead", statusMsg, message);
        ResearchRestfulHelper.addEmptyLineToReport();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("callRead(): response status[%s], %s".formatted(statusMsg, message));
        }
    }

    /**
     * Calls list reading.
     *
     * @param client the {@link Client}
     */
    private static void callReadList(Client client) {

        final WebTarget webResourceTarget = client.target(BOXES_URI);
        final Invocation invocation = webResourceTarget.request(MediaType.APPLICATION_JSON).buildGet();

        final String statusMsg;
        final String message;
        try (Response response = invocation.invoke()) {
            statusMsg = response.getStatusInfo().getReasonPhrase();
            message = "entity%s".formatted(response.readEntity(String.class));
        }
        ResearchRestfulHelper.addToReport(CLASS_NAME, "callReadList", statusMsg, message);
        ResearchRestfulHelper.addEmptyLineToReport();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("callReadList(): response status[%s]%n\t%s".formatted(statusMsg, message));
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

        final WebTarget webResourceTarget = client.target(BOXES_URI);
        final Entity<Box> entity = Entity.entity(new Box(id, text), MediaType.APPLICATION_JSON);
        final Invocation invocation =
                webResourceTarget.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).buildPut(entity);

        final String statusMsg;
        try (Response response = invocation.invoke()) {
            statusMsg = response.getStatusInfo().getReasonPhrase();
        }
        final String message = "id[%d], text[%s]".formatted(id, text);
        ResearchRestfulHelper.addToReport(CLASS_NAME, "callUpdate", statusMsg, message);
        ResearchRestfulHelper.addEmptyLineToReport();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("callUpdate(): response status[%s], %s".formatted(statusMsg, message));
        }
    }

    /**
     * Calls entity deletion.
     *
     * @param client the {@link Client}
     * @param id     the id
     */
    private static void callDelete(Client client, int id) {

        final WebTarget webResourceTarget = client.target(BOXES_URI);
        final Invocation invocation =
                webResourceTarget.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).buildDelete();

        final String statusMsg;
        try (Response response = invocation.invoke()) {
            statusMsg = response.getStatusInfo().getReasonPhrase();
        }
        final String message = "id[%d]".formatted(id);
        ResearchRestfulHelper.addToReport(CLASS_NAME, "callDelete", statusMsg, message);
        ResearchRestfulHelper.addEmptyLineToReport();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("callDelete(): response status[%s], %s".formatted(statusMsg, message));
        }
    }
}
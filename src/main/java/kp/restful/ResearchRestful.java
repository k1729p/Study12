package kp.restful;

import kp.restful.client.BoxesClient;
import kp.restful.client.ContentClient;
import kp.restful.data.SetOfBoxes;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Research Jakarta RESTful Web Services using JDK HTTP Server.
 * <p>
 * <a href="https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest4x/index.html">
 * Jersey User Guide</a>
 * </p>
 */
public class ResearchRestful {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final URI ROOT_URI = URI.create("http://localhost:8080/");
    private static final ResourceConfig RESOURCE_CONFIG = new ResourceConfig().packages("kp.restful.data");
    private static final String PROMPT_MESSAGE = """
            pause():
            *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***
            *** Start "02 CURL call server.bat".
            *** After that batch run ends, press the 'Enter' in this window to shutdown server.
            """;

    /**
     * Runs HTTP servers.
     * <ul>
     * <li>Uses Jersey with Grizzly HTTP Server.</li>
     * <li>With 'GrizzlyHttpServerFactory' creates the HttpServer instance configured as a Jersey container.</li>
     * </ul>
     */
    public void process() {

        while (true) {
            int chosenOption = ResearchRestfulHelper.showButtons();
            if (chosenOption < 0 || chosenOption > 2) {
                break;
            }
            final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(ROOT_URI, RESOURCE_CONFIG);
            processClient(chosenOption);
            httpServer.shutdownNow();
        }
    }

    /**
     * Processes the client based on the chosen option.
     *
     * @param chosenOption the chosen option
     */
    private static void processClient(int chosenOption) {

        ResearchRestfulHelper.clearReport();
        switch (chosenOption) {
            case 0 -> {
                ContentClient.process();
                ResearchRestfulHelper.showContentResults();
            }
            case 1 -> {
                SetOfBoxes.reset();
                BoxesClient.process();
                ResearchRestfulHelper.showBoxesResults();
            }
            case 2 -> {
                SetOfBoxes.reset();
                ResearchRestfulHelper.setNumber(1);
                pause();
                ResearchRestfulHelper.showBoxesExternalResults();
            }
            default -> throw new IllegalStateException("Unexpected value: " + chosenOption);
        }
    }

    /**
     * Pauses this application for running 'curl' in an external batch.
     */
    private static void pause() {

        if (logger.isLoggable(Level.INFO)) {
            logger.info(PROMPT_MESSAGE);
        }
        new Scanner(System.in).nextLine();
    }
}
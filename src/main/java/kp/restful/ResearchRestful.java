package kp.restful;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import kp.restful.client.BoxesClient;
import kp.restful.client.ContentClient;
import kp.restful.data.SetOfBoxes;

/**
 * Research Jakarta RESTful Web Services using JDK HTTP Server.
 * <p>
 * <a href=
 * "https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest3x/index.html"
 * >Jersey User Guide</a>
 * 
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
	 * The constructor.
	 */
	public ResearchRestful() {
		super();
	}

	/**
	 * Runs HTTP servers.
	 * <p>
	 * With 'GrizzlyHttpServerFactory' creates the HttpServer instance configured as
	 * a Jersey container.
	 */
	public void process() {
		boolean loopFlag = true;
		while (loopFlag) {
			int result = ResearchRestfulHelper.showButtons();
			switch (result) {
			case 0:
				final HttpServer httpServerA = GrizzlyHttpServerFactory.createHttpServer(ROOT_URI, RESOURCE_CONFIG);
				ResearchRestfulHelper.clearReport();
				ContentClient.process();
				httpServerA.shutdownNow();
				ResearchRestfulHelper.showContentResults();
				break;
			case 1:
				final HttpServer httpServerB = GrizzlyHttpServerFactory.createHttpServer(ROOT_URI, RESOURCE_CONFIG);
				SetOfBoxes.reset();
				ResearchRestfulHelper.clearReport();
				BoxesClient.process();
				httpServerB.shutdownNow();
				ResearchRestfulHelper.showBoxesResults();
				break;
			case 2:
				final HttpServer httpServerC = GrizzlyHttpServerFactory.createHttpServer(ROOT_URI, RESOURCE_CONFIG);
				SetOfBoxes.reset();
				ResearchRestfulHelper.clearReport();
				ResearchRestfulHelper.setNumber(1);
				pause();
				httpServerC.shutdownNow();
				ResearchRestfulHelper.showBoxesExternalResults();
				break;
			default:
				// Go Back
				loopFlag = false;
			}
		}
	}

	/**
	 * Pause this application for running 'curl' in external batch.
	 * 
	 */
	private static void pause() {

		if (logger.isLoggable(Level.INFO)) {
			logger.info(PROMPT_MESSAGE);
		}
		try {
			System.in.read();
		} catch (IOException e) {
			logger.severe(String.format("pause(): exception[%s]", e.getMessage()));
		}
	}
}
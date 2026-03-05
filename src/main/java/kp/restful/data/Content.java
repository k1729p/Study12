package kp.restful.data;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;
import kp.restful.ResearchRestfulHelper;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Content.
 * <p>
 * Example of a root resource class using JAX-RS annotations.
 * </p>
 */
@Path("content")
public class Content {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String CLASS_NAME = Content.class.getSimpleName();

    /**
     * Gets text using path parameter and query parameter.
     * <p>
     * Resource method annotated with {@link PathParam} and {@link QueryParam}.
     * </p>
     *
     * @param patPar the path parameter
     * @param quePar the query parameter
     * @return the content
     */
    @GET
    @Path("pq/{pat_par}")
    public String getUsingPathAndQuery(@PathParam("pat_par") String patPar, @QueryParam("que_par") String quePar) {

        final String message = "patPar[%s], quePar[%s]".formatted(patPar, quePar);
        ResearchRestfulHelper.addToReport(CLASS_NAME, "getUsingPathAndQuery", message);

        final String response = "abc";
        if (logger.isLoggable(Level.INFO)) {
            logger.info("getUsingPathAndQuery(): %s".formatted(message));
        }
        return response;
    }

    /**
     * Gets text using context parameter.
     * <p>
     * Resource method annotated with {@link Context}.
     * </p>
     *
     * @param uriInfo the {@link UriInfo}
     * @return the content
     */
    @GET
    @Path("c/{pat_par}")
    public String getUsingContext(@Context UriInfo uriInfo) {

        final MultivaluedMap<String, String> queParMap = uriInfo.getQueryParameters();
        final MultivaluedMap<String, String> patParMap = uriInfo.getPathParameters();
        final String message = "patPar%s, quePar%s".formatted(patParMap.get("pat_par"), queParMap.get("que_par"));
        ResearchRestfulHelper.addToReport(CLASS_NAME, "getUsingContext", message);

        final String response = "xyz";
        if (logger.isLoggable(Level.INFO)) {
            logger.info("getUsingContext(): %s".formatted(message));
        }
        return response;
    }
}
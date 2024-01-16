package kp.restful.data;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.UriInfo;
import kp.restful.ResearchRestfulHelper;

/**
 * The root resource class. The content.
 * 
 */
@Path("content")
public class Content {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	private static final String CLASS_NAME = Content.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public Content() {
		super();
	}

	/**
	 * The resource method using @PathParam and @QueryParam.
	 * 
	 * @param patPar the path parameter
	 * @param quePar the query parameter
	 * @return the content
	 */
	@GET
	@Path("pq/{pat_par}")
	public String getUsingPathAndQuery(@PathParam("pat_par") String patPar, @QueryParam("que_par") String quePar) {

		final String message = String.format("patPar[%s], quePar[%s]", patPar, quePar);
		ResearchRestfulHelper.addToReport(CLASS_NAME, "getUsingPathAndQuery", message);

		final String response = "abc";
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("getUsingPathAndQuery(): %s", message));
		}
		return response;
	}

	/**
	 * The resource method using @Context.
	 * 
	 * @param uriInfo the URI info
	 * @return the content
	 */
	@GET
	@Path("c/{pat_par}")
	public String getUsingContext(@Context UriInfo uriInfo) {

		final MultivaluedMap<String, String> queParMap = uriInfo.getQueryParameters();
		final MultivaluedMap<String, String> patParMap = uriInfo.getPathParameters();
		final String message = String.format("patPar%s, quePar%s", patParMap.get("pat_par"), queParMap.get("que_par"));
		ResearchRestfulHelper.addToReport(CLASS_NAME, "getUsingContext", message);

		final String response = "xyz";
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("getUsingContext(): %s", message));
		}
		return response;
	}
}
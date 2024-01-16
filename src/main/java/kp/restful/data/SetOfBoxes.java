package kp.restful.data;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import kp.restful.ResearchRestfulHelper;

/**
 * The root resource class. The set of boxes.
 * 
 */
@Path("boxes")
public class SetOfBoxes {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private static final AtomicInteger atomic = new AtomicInteger(1);
	private static final Map<Integer, Box> boxMap = new TreeMap<>();
	private static final String MESSAGE_FMT = "id[%d], boxMap size[%d]";
	private static final String CLASS_NAME = SetOfBoxes.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public SetOfBoxes() {
		super();
	}

	/**
	 * Resetting data store for repeatable runs of the client.
	 * 
	 */
	public static void reset() {
		boxMap.clear();
		atomic.set(1);
	}

	/**
	 * <B>CREATE</B> the single {@link Box} (with validation enabled).
	 * 
	 * @param box the {@link Box}
	 * @return the confirmation response
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response createBox(@Valid Box box) {

		final int id = atomic.getAndIncrement();
		box.setId(id);
		boxMap.put(id, box);
		final URI uri = URI.create(String.format("boxes/%d", id));
		final Response response = Response.created(uri).build();

		final String message = String.format(MESSAGE_FMT, id, boxMap.size());
		ResearchRestfulHelper.addToReport(CLASS_NAME, "createBox", message);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("createBox(): %s", message));
		}
		return response;
	}

	/**
	 * <B>READ</B> the single {@link Box}.
	 *
	 * @param id the id
	 * @return the {@link Box}
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Box readBox(@PathParam("id") int id) {

		final Box box = boxMap.get(id);

		final String message = String.format(MESSAGE_FMT, id, boxMap.size());
		ResearchRestfulHelper.addToReport(CLASS_NAME, "readBox", message);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("readBox(): %s", message));
		}
		return box;
	}

	/**
	 * <B>READ</B> all boxes.
	 * 
	 * @return the list of boxes
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Box> readBoxes() {

		final List<Box> boxList = boxMap.values().stream().toList();
		final String message = String.format("boxMap size[%d]", boxMap.size());
		ResearchRestfulHelper.addToReport(CLASS_NAME, "readBoxes", message);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("readBoxes(): %s", message));
		}
		return boxList;
	}

	/**
	 * <B>UPDATE</B> the single {@link Box} (with validation enabled).
	 * 
	 * @param id  the id
	 * @param box the {@link Box}
	 * @return the response
	 */
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBox(@PathParam("id") int id, @Valid Box box) {

		if (!boxMap.containsKey(id)) {
			final Response response = Response.status(Status.NOT_FOUND).build();
			final String message = String.format("not updated, bad id[%d], boxMap size[%d]", id, boxMap.size());
			ResearchRestfulHelper.addToReport(CLASS_NAME, "updateBox", message);
			if (logger.isLoggable(Level.WARNING)) {
				logger.warning(String.format("updateBox(): %s", message));
			}
			return response;
		}
		boxMap.put(id, box);
		final Response response = Response.ok().status(Status.SEE_OTHER).build();
		final String message = String.format(MESSAGE_FMT, id, boxMap.size());
		ResearchRestfulHelper.addToReport(CLASS_NAME, "updateBox", message);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("updateBox(): %s", message));
		}
		return response;
	}

	/**
	 * <B>DELETE</B> the single {@link Box}.
	 *
	 * @param id the id
	 * @return the response
	 */
	@DELETE
	@Path("{id}")
	public Response deleteBox(@PathParam("id") int id) {

		if (!boxMap.containsKey(id)) {
			final Response response = Response.status(Status.NOT_FOUND).build();
			final String message = String.format("not deleted, bad id[%d], boxMap size[%d]", id, boxMap.size());
			ResearchRestfulHelper.addToReport(CLASS_NAME, "deleteBox", message);
			if (logger.isLoggable(Level.WARNING)) {
				logger.warning(String.format("deleteBox(): %s", message));
			}
			return response;
		}
		boxMap.remove(id);
		final Response response = Response.noContent().build();
		final String message = String.format(MESSAGE_FMT, id, boxMap.size());
		ResearchRestfulHelper.addToReport(CLASS_NAME, "deleteBox", message);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("deleteBox(): %s", message));
		}
		return response;
	}
}
package kp.restful.data;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import kp.restful.ResearchRestfulHelper;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Set of boxes.
 * <p>
 * Example of a root resource class using JAX-RS annotations.
 * </p>
 */
@Path("boxes")
public class SetOfBoxes {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final AtomicInteger atomic = new AtomicInteger(1);
    private static final Map<Integer, Box> boxMap = new TreeMap<>();
    private static final String MESSAGE_FMT = "id[%d], boxMap size[%d]";
    private static final String CLASS_NAME = SetOfBoxes.class.getSimpleName();

    /**
     * Resets data store for repeatable runs of the client.
     */
    public static void reset() {
        boxMap.clear();
        atomic.set(1);
    }

    /**
     * Creates a single {@link Box} (with validation enabled).
     * <p>
     * Annotated with resource method designator {@link POST}.
     * </p>
     *
     * @param box the {@link Box}
     * @return the confirmation response
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createBox(@Valid Box box) {

        final int id = atomic.getAndIncrement();
        box.setId(id);
        boxMap.put(id, box);
        final URI uri = URI.create("boxes/%d".formatted(id));
        final Response response = Response.created(uri).build();

        final String message = MESSAGE_FMT.formatted(id, boxMap.size());
        ResearchRestfulHelper.addToReport(CLASS_NAME, "createBox", message);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("createBox(): %s".formatted(message));
        }
        return response;
    }

    /**
     * Reads a single {@link Box}.
     * <p>
     * Annotated with resource method designator {@link GET}.
     * </p>
     *
     * @param id the id
     * @return the {@link Box}
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Box readBox(@PathParam("id") int id) {

        final Box box = boxMap.get(id);
        final String message = MESSAGE_FMT.formatted(id, boxMap.size());
        ResearchRestfulHelper.addToReport(CLASS_NAME, "readBox", message);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("readBox(): %s".formatted(message));
        }
        return box;
    }

    /**
     * Reads all boxes.
     * <p>
     * Annotated with resource method designator {@link GET}.
     * </p>
     *
     * @return the list of boxes
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Box> readBoxes() {

        final List<Box> boxList = List.copyOf(boxMap.values());
        final String message = "boxMap size[%d]".formatted(boxMap.size());
        ResearchRestfulHelper.addToReport(CLASS_NAME, "readBoxes", message);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("readBoxes(): %s".formatted(message));
        }
        return boxList;
    }

    /**
     * Updates a single {@link Box} (with validation enabled).
     * <p>
     * Annotated with resource method designator {@link PUT}.
     * </p>
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
            final String message = "not updated, bad id[%d], boxMap size[%d]".formatted(id, boxMap.size());
            ResearchRestfulHelper.addToReport(CLASS_NAME, "updateBox", message);
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning("updateBox(): %s".formatted(message));
            }
            return response;
        }
        boxMap.put(id, box);
        final Response response = Response.ok().status(Status.SEE_OTHER).build();
        final String message = MESSAGE_FMT.formatted(id, boxMap.size());
        ResearchRestfulHelper.addToReport(CLASS_NAME, "updateBox", message);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("updateBox(): %s".formatted(message));
        }
        return response;
    }

    /**
     * Deletes a single {@link Box}.
     * <p>
     * Annotated with resource method designator {@link DELETE}.
     * </p>
     *
     * @param id the id
     * @return the response
     */
    @DELETE
    @Path("{id}")
    public Response deleteBox(@PathParam("id") int id) {

        if (!boxMap.containsKey(id)) {
            final Response response = Response.status(Status.NOT_FOUND).build();
            final String message = "not deleted, bad id[%d], boxMap size[%d]".formatted(id, boxMap.size());
            ResearchRestfulHelper.addToReport(CLASS_NAME, "deleteBox", message);
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning("deleteBox(): %s".formatted(message));
            }
            return response;
        }
        boxMap.remove(id);
        final Response response = Response.noContent().build();
        final String message = MESSAGE_FMT.formatted(id, boxMap.size());
        ResearchRestfulHelper.addToReport(CLASS_NAME, "deleteBox", message);
        if (logger.isLoggable(Level.INFO)) {
            logger.info("deleteBox(): %s".formatted(message));
        }
        return response;
    }
}
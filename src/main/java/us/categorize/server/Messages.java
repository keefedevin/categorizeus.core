package us.categorize.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import us.categorize.model.Message;

@Path("/messages")
public class Messages {
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@QueryParam("name") String name) {
		Message message = new Message();
		message.setCreator(name);
		return Response.status(200).entity(message).build();
	}
	
	@POST
	@Path("consumeTest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response consumeTest(Message message) {
		message.setInternalId(42);
		return Response.status(200).entity(message).build();
	}
}

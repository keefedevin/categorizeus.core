package us.categorize.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import us.categorize.model.Message;

@Path("/messages")
public class Messages {
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message) {
		message.setInternalId("42");
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consumeTest(@QueryParam("tags") String tags) {
		Message message = new Message();
		message.setBody(tags);
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessage(@PathParam("id") String id) {
		Message message = new Message();
		message.setCreator("keefe");
		message.setInternalId(id);
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("{id}/thread")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessageThread(@PathParam("id") String id) {
		Message message = new Message();
		message.setCreator("keefe");
		message.setInternalId(id);
		Message message2 = new Message();
		message.setCreator("keefe2");
		message.setInternalId(id+"2");
		Message messages[] = new Message[] {message,message2};
		return Response.status(200).entity(messages).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMessage(@PathParam("id") String id) {
		Message message = new Message();
		message.setCreator("message deleted");
		message.setInternalId(id);
		return Response.status(200).entity(message).build();
	}
	
	@PUT
	@Path("{id}/tags")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagMessage(@PathParam("id") String id, String[] tags) {
		for(String t : tags) System.out.println(t);
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has been tagged");
		return Response.status(200).entity(message).build();
	}
	@PUT
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagMessage(@PathParam("id") String id, @PathParam("tag") String tag) {
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has been tagged as " + tag);
		return Response.status(200).entity(message).build();
	}
	@DELETE
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeMessageTag(@PathParam("id") String id, @PathParam("tag") String tag) {
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has tag removed " + tag);
		return Response.status(200).entity(message).build();
	}
	

}

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

import us.categorize.Configuration;
import us.categorize.api.MessageStore;
import us.categorize.api.MessageStoreStubImpl;
import us.categorize.model.Message;

@Path("/messages")
public class Messages {
	
	protected MessageStore messageStore;
	
	public Messages() {
		//TODO this is for testing purposes, this MUST be replaced by DI or something not stupid
		this.messageStore = Configuration.instance().getMessageStore();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message) {
		message = messageStore.createMessage(message);
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagSearch(@QueryParam("tags") String tags) {
		Message messages[] = messageStore.tagSearch(tags.split(","));
		return Response.status(200).entity(messages).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessage(@PathParam("id") String id) {
		Message message = messageStore.readMessage(id);
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("{id}/thread")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessageThread(@PathParam("id") String id) {
		Message messages[] = messageStore.readMessageThread(id);
		return Response.status(200).entity(messages).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMessage(@PathParam("id") String id) {
		boolean deleted = messageStore.deleteMessage(id);
		return Response.status(200).entity(deleted).build();
	}
	
	@PUT
	@Path("{id}/tags")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagMessage(@PathParam("id") String id, String[] tags) {
		boolean success = messageStore.tagMessage(id, tags);
		return Response.status(200).entity(success).build();
	}
	@PUT
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessageTag(@PathParam("id") String id, @PathParam("tag") String tag) {
		boolean success = messageStore.addMessageTag(id, tag);
		return Response.status(200).entity(success).build();
	}
	@DELETE
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeMessageTag(@PathParam("id") String id, @PathParam("tag") String tag) {
		boolean success = messageStore.removeMessageTag(id, tag);
		return Response.status(200).entity(success).build();
	}
	

}

package us.categorize.server;

import java.io.InputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import us.categorize.CategorizeUs;
import us.categorize.api.Authorizer;
import us.categorize.api.MessageStore;
import us.categorize.api.UserStore;
import us.categorize.model.Attachment;
import us.categorize.model.Message;
import us.categorize.model.MetaMessage;
import us.categorize.model.TagQuery;
import us.categorize.model.User;

@Path("/messages")
public class Messages {

	protected MessageStore messageStore;
	protected UserStore userStore;
	protected Authorizer authorizer;

	public Messages() {
		// TODO this is for testing purposes, this MUST be replaced by DI or something
		this.messageStore = CategorizeUs.instance().getMessageStore();
		this.authorizer = CategorizeUs.instance().getAuthorizer();
		this.userStore = CategorizeUs.instance().getUserStore();
	}

	// TODO maybe this should be in a filter, but this is small and seems reasonable
	// to do here for now
	private Response authorizationCheck(Cookie cookie, String path, String method) {
		String cookieValue = cookie == null ? null : cookie.getValue();
		if (cookie != null)
			System.out.println("Cookie is " + cookieValue);// TODO temp for debugging
		if (!authorizer.authorize(cookieValue, path, method)) {
			return Response.noContent().status(403).build();
		}
		return null;
	}

	private Response authorizationCheck(User user, String path, String method) {
		if (user == null || !authorizer.authorize(user, path, method)) {
			return Response.noContent().status(403).build();
		}
		return null;
	}

	private ResponseBuilder ensureCookie(Cookie cookie, ResponseBuilder response) {
		if (cookie == null) {
			NewCookie newCookie = new NewCookie("categorizeus", UUID.randomUUID().toString());
			response.cookie(newCookie);
		}
		return response;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message, @CookieParam("categorizeus") Cookie cookie) {
		User user = null;
		if (cookie != null) {
			user = userStore.getPrincipal(cookie.getValue());
		}
		Response authCheck = authorizationCheck(user, "/messages", "POST");
		if (authCheck != null)
			return authCheck;
		message.setPostedBy(user.getId());
		message = messageStore.createMessage(message);
		ResponseBuilder response = Response.status(200).entity(message);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagSearch(@CookieParam("categorizeus") Cookie cookie, @QueryParam("tags") String tags,
			@QueryParam("queryId") String queryId,
			@QueryParam("loadMetadata") String loadMetadata, 
			@QueryParam("before") String before,
			@QueryParam("after") String after,
			@QueryParam("count") Integer count,
			@QueryParam("sort") String sort
			) {
		Response authCheck = authorizationCheck(cookie, "/messages", "GET");
		if (authCheck != null)
			return authCheck;
		String tagArray[] = tags == null || "".equals(tags) ? new String[] {} : tags.split(",");
		boolean loadMeta = loadMetadata == null ? false : Boolean.parseBoolean(loadMetadata);
		TagQuery query = new TagQuery();
		query.setTags(tagArray);
		query.setLoadMetadata(loadMeta);
		if(count!=null) {
			query.setCount(count);
		}
		query.setId(queryId);
		query.setSort(sort);
		query.setAfter(after);
		query.setBefore(before);
		
		ResponseBuilder response;
		if (loadMeta) {
			MetaMessage messages[] = messageStore.tagSearchFull(query);
			response = Response.status(200).entity(messages);
		} else {
			Message messages[] = messageStore.tagSearch(query);
			response = Response.status(200).entity(messages);
		}
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessage(@PathParam("id") String id, @CookieParam("categorizeus") Cookie cookie) {
		Response authCheck = authorizationCheck(cookie, "/messages/{id}", "GET");
		if (authCheck != null)
			return authCheck;
		Message message = messageStore.readMessage(id);
		ResponseBuilder response = Response.status(200).entity(message);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@POST
	@Path("{id}/attachments")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAttachment(@CookieParam("categorizeus") Cookie cookie, @PathParam("id") String id,
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		Response authCheck = authorizationCheck(cookie, "/messages/{id}/attachments", "POST");
		if (authCheck != null)
			return authCheck;
		Attachment attachment = new Attachment();
		attachment.setFilename(fileDetail.getFileName());
		String fn = attachment.getFilename();
		if(fn!=null) {
			attachment.setExtension(fn.substring(fn.lastIndexOf('.')));
		}
		attachment.setLength(fileDetail.getSize());
		messageStore.createAttachment(attachment, uploadedInputStream);
		Message dummyMessage = new Message();
		dummyMessage.setId(id);
		messageStore.associateAttachment(dummyMessage, attachment);
		ResponseBuilder response = Response.status(200).entity(true);
		response = ensureCookie(cookie, response);
		return response.build();

	}

	@GET
	@Path("{id}/thread")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessageThread(@PathParam("id") String id, @CookieParam("categorizeus") Cookie cookie) {
		Response authCheck = authorizationCheck(cookie, "/messages/{id]/thread", "GET");
		if (authCheck != null)
			return authCheck;
		MetaMessage messages[] = messageStore.readMessageThread(id);
		ResponseBuilder response = Response.status(200).entity(messages);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMessage(@PathParam("id") String id, @CookieParam("categorizeus") Cookie cookie) {
		Response authCheck = authorizationCheck(cookie, "/messages/{id}", "DELETE");
		if (authCheck != null)
			return authCheck;
		boolean deleted = messageStore.deleteMessage(id);
		ResponseBuilder response = Response.status(200).entity(deleted);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@PUT
	@Path("{id}/tags")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response tagMessage(@PathParam("id") String id, String[] tags, @CookieParam("categorizeus") Cookie cookie) {
		User user = null;
		if (cookie != null) {
			user = userStore.getPrincipal(cookie.getValue());
		}
		Response authCheck = authorizationCheck(user, "/messages/{id}/tags", "PUT");
		if (authCheck != null)
			return authCheck;
		boolean success = messageStore.tagMessage(id, tags, user);
		ResponseBuilder response = Response.status(200).entity(success);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@PUT
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessageTag(@PathParam("id") String id, @PathParam("tag") String tag,
			@CookieParam("categorizeus") Cookie cookie) {
		User user = null;
		if (cookie != null) {
			user = userStore.getPrincipal(cookie.getValue());
		}
		Response authCheck = authorizationCheck(user, "/messages/{id}/tags/{tag}", "PUT");
		if (authCheck != null)
			return authCheck;
		boolean success = messageStore.addMessageTag(id, tag, user);
		ResponseBuilder response = Response.status(200).entity(success);
		response = ensureCookie(cookie, response);
		return response.build();
	}

	@DELETE
	@Path("{id}/tags/{tag}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeMessageTag(@PathParam("id") String id, @PathParam("tag") String tag,
			@CookieParam("categorizeus") Cookie cookie) {
		User user = null;
		if (cookie != null) {
			user = userStore.getPrincipal(cookie.getValue());
		}
		Response authCheck = authorizationCheck(user, "/messages/{id}/tags/{tag}", "DELETE");
		if (authCheck != null)
			return authCheck;
		boolean success = messageStore.removeMessageTag(id, tag, user);
		ResponseBuilder response = Response.status(200).entity(success);
		response = ensureCookie(cookie, response);
		return response.build();
	}

}

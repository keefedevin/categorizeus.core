package us.categorize.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import us.categorize.model.User;

@Path("/users")
public class Users {
	@GET
	@Path("principal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readMessage() {
		User user = new User();
		user.setDisplayName("currently logged in user");
		user.setId("uuid");
		return Response.status(200).entity(user).build();
	}
}

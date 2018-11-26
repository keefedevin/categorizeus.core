package us.categorize.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import us.categorize.Configuration;
import us.categorize.api.UserStore;
import us.categorize.api.UserStoreStubImpl;
import us.categorize.model.User;

@Path("/users")
public class Users {
	protected UserStore userStore;
	public Users() {
		this.userStore = Configuration.instance().getUserStore();
	}
	@GET
	@Path("principal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrincipal() {
		User user = userStore.getPrincipal();
		return Response.status(200).entity(user).build();
	}
}

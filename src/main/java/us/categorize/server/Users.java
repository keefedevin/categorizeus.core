package us.categorize.server;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import us.categorize.CategorizeUs;
import us.categorize.api.UserStore;
import us.categorize.model.User;

@Path("/users")
public class Users {
	protected UserStore userStore;
	public Users() {
		this.userStore = CategorizeUs.instance().getUserStore();
	}
	@GET
	@Path("principal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrincipal(@CookieParam("categorizeus") Cookie cookie) {
		if(cookie==null) {
			return Response.noContent().status(404).build();
		}
		User user = userStore.getPrincipal(cookie.getValue());
		if(user==null) {
			return Response.noContent().status(404).build();
		}
		user.setPasshash(null);
		return Response.status(200).entity(user).build();
	}
}

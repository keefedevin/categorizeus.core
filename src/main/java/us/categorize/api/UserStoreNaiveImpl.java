package us.categorize.api;

import us.categorize.model.User;

public class UserStoreNaiveImpl implements UserStore {

	@Override
	public User getPrincipal() {
		User user = new User();
		user.setDisplayName("currently logged in user");
		user.setId("uuid");
		return user;
	}

}

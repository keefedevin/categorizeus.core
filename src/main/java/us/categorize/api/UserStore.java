package us.categorize.api;

import us.categorize.model.User;

public interface UserStore {
	User getPrincipal();
	boolean registerUser(User user);
	boolean establishUserSession(User user);
}

package us.categorize.api;

import us.categorize.model.User;

public interface UserStore {
	User getPrincipal(String sessionKey);
	User getUser(String id);
	boolean registerUser(User user);
	boolean establishUserSession(User user, String sessionKey);
	boolean destroySessionUser(String sessionUUID);
}

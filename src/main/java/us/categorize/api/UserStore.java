package us.categorize.api;

import us.categorize.model.User;

public interface UserStore {
	User getPrincipal();
}

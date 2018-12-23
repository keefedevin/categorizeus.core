package us.categorize.api.stub;

import us.categorize.api.UserStore;
import us.categorize.model.User;

public class UserStoreStubImpl implements UserStore {

	@Override
	public User getPrincipal(String sessionKey) {
		User user = new User();
		user.setId(42+"");
		user.setUsername("username");
		user.setEmail("keefe@categorize.us");
		user.setPasshash("secret stuff!");
		return user;
	}

	@Override
	public boolean registerUser(User user) {
		return true;
	}

	@Override
	public boolean establishUserSession(User user, String sessionKey) {
		return true;
	}

	@Override
	public boolean destroySessionUser(String sessionUUID) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public User getUser(String id) {
		User user = new User();
		user.setId(id);
		return user;
	}

}

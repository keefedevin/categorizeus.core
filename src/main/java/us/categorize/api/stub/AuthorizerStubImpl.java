package us.categorize.api.stub;

import us.categorize.api.Authorizer;
import us.categorize.model.User;

public class AuthorizerStubImpl implements Authorizer {

	@Override
	public boolean authorize(String sessionKey, String path, String method) {
		return true;
	}

	@Override
	public boolean authorize(User user, String path, String method) {
		// TODO Auto-generated method stub
		return false;
	}

}

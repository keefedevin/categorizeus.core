package us.categorize.api.stub;

import us.categorize.api.Authorizer;

public class AuthorizerStubImpl implements Authorizer {

	@Override
	public boolean authorize(String sessionKey, String path, String method) {
		return true;
	}

}

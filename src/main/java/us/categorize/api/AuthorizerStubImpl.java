package us.categorize.api;

public class AuthorizerStubImpl implements Authorizer {

	@Override
	public boolean authorize(String sessionKey, String path, String method) {
		return true;
	}

}

package us.categorize.api;

public interface Authorizer {//TODO need to think about this
	boolean authorize(String sessionKey, String path, String method);//TODO should this be replaced with something to allow different response codes?
}

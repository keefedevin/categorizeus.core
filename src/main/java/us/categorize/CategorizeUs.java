package us.categorize;

import us.categorize.api.Authorizer;
import us.categorize.api.MessageStore;
import us.categorize.api.UserStore;

public class CategorizeUs {
	
	private static CategorizeUs singleton;
	private UserStore userStore; //TODO this is awful
	private MessageStore messageStore;//TODO this is awful
	private Authorizer authorizer;//TODO still awful
	
	private String googleClientId, googleClientSecret;//TODO the horror continues
	private String host = "http://localhost:8080";
	private CategorizeUs() {
		
	}
	
	public static CategorizeUs instance() {
		//double locking problem
		//TODO this must be replaced with DI or something not stupid like this
		if(singleton==null) singleton = new CategorizeUs();
		return singleton;
	}
	public UserStore getUserStore() {
		return userStore;
	}

	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

	public Authorizer getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(Authorizer authorizer) {
		this.authorizer = authorizer;
	}

	public String getGoogleClientId() {
		return googleClientId;
	}

	public void setGoogleClientId(String googleClientId) {
		this.googleClientId = googleClientId;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	public void setGoogleClientSecret(String googleClientSecret) {
		this.googleClientSecret = googleClientSecret;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}

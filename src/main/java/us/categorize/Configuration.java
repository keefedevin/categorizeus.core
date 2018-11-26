package us.categorize;

import us.categorize.api.MessageStore;
import us.categorize.api.UserStore;

public class Configuration {
	
	private static Configuration singleton;
	private UserStore userStore; //TODO this is awful
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

	private MessageStore messageStore;//TODO this is awful
	
	private Configuration() {
		
	}
	
	public static Configuration instance() {
		//double locking problem
		//TODO this must be replaced with DI or something not stupid like this
		if(singleton==null) singleton = new Configuration();
		return singleton;
	}
}

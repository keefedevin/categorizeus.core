package us.categorize.api;

import us.categorize.model.Message;

public interface MessageStore {
	Message createMessage(Message message);//message serialized from transport is input
	Message[] tagSearch(String tags[]);
	Message readMessage(String id);
	Message[] readMessageThread(String id);
	boolean deleteMessage(String id);
	boolean tagMessage(String id, String tags[]);
	boolean addMessageTag(String id, String tag);
	boolean removeMessageTag(String id, String tag);
}

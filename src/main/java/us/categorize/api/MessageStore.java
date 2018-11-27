package us.categorize.api;

import us.categorize.model.Message;

public interface MessageStore {
	Message createMessage(Message message);//message serialized from transport is input
	Message[] tagSearch(String tags[]);
	Message readMessage(long id);
	Message[] readMessageThread(long id);
	boolean deleteMessage(long id);
	boolean tagMessage(long id, String tags[]);
	boolean addMessageTag(long id, String tag);
	boolean removeMessageTag(long id, String tag);
}

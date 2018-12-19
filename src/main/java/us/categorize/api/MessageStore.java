package us.categorize.api;

import java.io.InputStream;

import us.categorize.model.Attachment;
import us.categorize.model.Message;
import us.categorize.model.MetaMessage;
import us.categorize.model.User;

public interface MessageStore {
	Message createMessage(Message message);//message marshalled from transport is input
	Message[] tagSearch(String tags[], Integer pageOn, Integer pageSize);
	MetaMessage[] tagSearchFull(String tags[], Integer pageOn, Integer pageSize);
	Message readMessage(long id);
	MetaMessage[] readMessageThread(long id);
	boolean deleteMessage(long id);
	boolean tagMessage(long id, String tags[], User user);
	boolean addMessageTag(long id, String tag, User user);
	boolean removeMessageTag(long id, String tag, User user);
	Attachment createAttachment(Attachment attachment, InputStream inputStream);
	Attachment readAttachment(Message message);
}

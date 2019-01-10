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
	Message readMessage(String id);
	MetaMessage[] readMessageThread(String id);
	boolean deleteMessage(String id);
	boolean tagMessage(String id, String tags[], User user);
	boolean addMessageTag(String id, String tag, User user);
	boolean removeMessageTag(String id, String tag, User user);
	Attachment createAttachment(Attachment attachment, InputStream inputStream);
	Attachment readAttachment(Message message);
	Attachment updateAttachment(Attachment attachment);
}

package us.categorize.api;

import java.io.InputStream;

import us.categorize.model.Attachment;
import us.categorize.model.Message;
import us.categorize.model.MetaMessage;

public interface MessageStore {
	Message createMessage(Message message);//message marshalled from transport is input
	Message[] tagSearch(String tags[], Integer pageOn, Integer pageSize);
	MetaMessage[] tagSearchFull(String tags[], Integer pageOn, Integer pageSize);
	Message readMessage(long id);
	MetaMessage[] readMessageThread(long id);
	boolean deleteMessage(long id);
	boolean tagMessage(long id, String tags[]);
	boolean addMessageTag(long id, String tag);
	boolean removeMessageTag(long id, String tag);
	Attachment createAttachment(Attachment attachment, InputStream inputStream);
	Attachment readAttachment(Message message);
}

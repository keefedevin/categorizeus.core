package us.categorize.api;

import java.io.InputStream;
import java.util.List;

import us.categorize.model.Attachment;
import us.categorize.model.Message;
import us.categorize.model.MetaMessage;
import us.categorize.model.TagQuery;
import us.categorize.model.User;

public interface MessageStore {
	Message createMessage(Message message);//message marshalled from transport is input
	Message[] tagSearch(TagQuery query);
	MetaMessage[] tagSearchFull(TagQuery query);
	Message readMessage(String id);
	MetaMessage[] readMessageThread(String id);
	boolean deleteMessage(String id);
	boolean tagMessage(String id, String tags[], User user);
	boolean addMessageTag(String id, String tag, User user);
	boolean removeMessageTag(String id, String tag, User user);
	Attachment createAttachment(Attachment attachment, InputStream inputStream);
	List<Attachment> readAttachments(Message message);
	Attachment updateAttachment(Attachment attachment);
	boolean associateAttachment(Message message, Attachment attachment);
	boolean signAttachment(Attachment attachment, String signature);//TODO should this be in attachment model as string list?
	Attachment findSignedAttachment(String signature);
	Attachment[] findAssociatedAttachments(Attachment attachment);
	
}

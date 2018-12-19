package us.categorize.api.stub;

import java.io.InputStream;
import java.util.Arrays;

import us.categorize.api.MessageStore;
import us.categorize.model.Attachment;
import us.categorize.model.Message;
import us.categorize.model.MetaMessage;
import us.categorize.model.User;

public class MessageStoreStubImpl implements MessageStore {

	@Override
	public Message createMessage(Message message) {
		message.setId(13);
		return message;
	}

	@Override
	public Message[] tagSearch(String[] tags, Integer pageOn, Integer pageSize) {
		Message message = new Message();
		message.setBody(Arrays.toString(tags));
		Message message2 = new Message();
		message.setBody("Second Body");
		return new Message[] {message, message2};
	}
	
	@Override
	public MetaMessage[] tagSearchFull(String[] tags, Integer pageOn, Integer pageSize) {
		Message message = new Message();
		message.setBody(Arrays.toString(tags));
		MetaMessage meta1 = new MetaMessage();
		meta1.setMessage(message);
		Message message2 = new Message();
		message2.setBody("Second Body");
		MetaMessage meta2 = new MetaMessage();
		meta2.setMessage(message2);
		MetaMessage[] data = new MetaMessage[2];
		data[0] = meta1;
		data[1] = meta2;
		return data;
	}

	@Override
	public Message readMessage(long id) {
		Message message = new Message();
		message.setPostedBy(42);
		message.setTitle("title");
		message.setBody("body");
		return message;
	}

	@Override
	public MetaMessage[] readMessageThread(long id) {
		Message message = new Message();
		message.setBody("abc123");
		MetaMessage meta1 = new MetaMessage();
		meta1.setMessage(message);
		Message message2 = new Message();
		message2.setBody("Second Body");
		MetaMessage meta2 = new MetaMessage();
		meta2.setMessage(message2);
		MetaMessage[] data = new MetaMessage[2];
		data[0] = meta1;
		data[1] = meta2;
		return data;
	}

	@Override
	public boolean deleteMessage(long id) {
		Message message = new Message();
		message.setBody("message deleted");
		message.setId(id);
		return true;
	}

	@Override
	public boolean tagMessage(long id, String[] tags, User user) {
		for(String t : tags) System.out.println(t);
		Message message = new Message();
		message.setId(7);
		message.setBody("Message has been tagged");
		return true;
	}

	@Override
	public boolean addMessageTag(long id, String tag, User user) {
		Message message = new Message();
		message.setId(id);
		message.setBody("Message has been tagged as " + tag);
		return true;
	}

	@Override
	public boolean removeMessageTag(long id, String tag, User user) {
		Message message = new Message();
		message.setId(id);
		message.setBody("Message has tag removed " + tag);
		return true;
	}

	@Override
	public Attachment createAttachment(Attachment attachment, InputStream inputStream) {
		attachment.setId(42);
		return attachment;
	}

	@Override
	public Attachment readAttachment(Message message) {
		return null;
	}



}

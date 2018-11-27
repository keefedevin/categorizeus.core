package us.categorize.api;

import java.util.Arrays;

import us.categorize.model.Message;

public class MessageStoreStubImpl implements MessageStore {

	@Override
	public Message createMessage(Message message) {
		message.setId(13);
		return message;
	}

	@Override
	public Message[] tagSearch(String[] tags) {
		Message message = new Message();
		message.setBody(Arrays.toString(tags));
		Message message2 = new Message();
		message.setBody("Second Body");
		return new Message[] {message, message2};
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
	public Message[] readMessageThread(long id) {
		Message message = new Message();
		message.setId(1);
		message.setPostedBy(1);
		message.setBody("the body");
		Message message2 = new Message();
		message.setId(2);
		message.setPostedBy(2);
		message.setBody("the body");
		Message messages[] = new Message[] {message,message2};
		return messages;
	}

	@Override
	public boolean deleteMessage(long id) {
		Message message = new Message();
		message.setBody("message deleted");
		message.setId(id);
		return true;
	}

	@Override
	public boolean tagMessage(long id, String[] tags) {
		for(String t : tags) System.out.println(t);
		Message message = new Message();
		message.setId(7);
		message.setBody("Message has been tagged");
		return true;
	}

	@Override
	public boolean addMessageTag(long id, String tag) {
		Message message = new Message();
		message.setId(id);
		message.setBody("Message has been tagged as " + tag);
		return true;
	}

	@Override
	public boolean removeMessageTag(long id, String tag) {
		Message message = new Message();
		message.setId(id);
		message.setBody("Message has tag removed " + tag);
		return true;
	}

}

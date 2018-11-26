package us.categorize.api;

import java.util.Arrays;

import us.categorize.model.Message;

public class MessageStoreNaiveImpl implements MessageStore {

	@Override
	public Message createMessage(Message message) {
		message.setInternalId("42");
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
	public Message readMessage(String id) {
		Message message = new Message();
		message.setCreator("keefe");
		message.setInternalId(id);
		return message;
	}

	@Override
	public Message[] readMessageThread(String id) {
		Message message = new Message();
		message.setCreator("keefe");
		message.setInternalId(id);
		Message message2 = new Message();
		message.setCreator("keefe2");
		message.setInternalId(id+"2");
		Message messages[] = new Message[] {message,message2};
		return messages;
	}

	@Override
	public boolean deleteMessage(String id) {
		Message message = new Message();
		message.setCreator("message deleted");
		message.setInternalId(id);
		return true;
	}

	@Override
	public boolean tagMessage(String id, String[] tags) {
		for(String t : tags) System.out.println(t);
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has been tagged");
		return true;
	}

	@Override
	public boolean addMessageTag(String id, String tag) {
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has been tagged as " + tag);
		return true;
	}

	@Override
	public boolean removeMessageTag(String id, String tag) {
		Message message = new Message();
		message.setInternalId(id);
		message.setBody("Message has tag removed " + tag);
		return true;
	}

}

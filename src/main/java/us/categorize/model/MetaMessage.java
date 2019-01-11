package us.categorize.model;

import java.util.List;

public class MetaMessage {
	private User postedBy;
	private String[] tags;//this may be relative to query context
	private Message message;
	private List<Attachment> attachments;
	
	public User getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(User postedBy) {
		if(postedBy!=null) postedBy.setPasshash(null);
		this.postedBy = postedBy;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
}

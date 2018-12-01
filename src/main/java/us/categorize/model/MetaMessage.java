package us.categorize.model;

public class MetaMessage {
	private User postedBy;
	private String[] tags;
	private Message message;
	private Attachment attachment;
	
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
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	
}
